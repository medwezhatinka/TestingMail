/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.Util;
import by.epam.lab.page.OpenedMessage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.Settings;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AddForwarding extends MessagePreparation {

    Settings settings;
    SendMessagePage page;

    @Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {"autentification"})
    public void forwarding() throws InterruptedException, Exception {
        settings = mailPage.openSettings();
        settings.openForwardingTab();
        settings.addForwardingAddress(CORRECT_EMAIL_TESTEROVSKI);
        mailPage.logout();
        mailPage = loginPage.Login(CORRECT_EMAIL_TESTEROVSKI, CORRECT_PASSWORD_TESTEROVSKI)
                .waitForSuccessfulLogin();
        mailPage.openMessage();
        OpenedMessage openedMessage = new OpenedMessage(getDriver());
        String code = Util.substringAfter(openedMessage.getMessageText(), CONFIRMATION_CODE, 10);
        mailPage.logout();
        mailPage = loginPage.Login(CORRECT_EMAIL_TEST, CORRECT_PASSWORD_TEST)
                .waitForSuccessfulLogin();
        settings = mailPage.openSettings();
        settings.openForwardingTab();
        settings.verifyCode(code);
        settings.forwardOn();
        mailPage.logout();
        mailPage = loginPage.Login(CORRECT_EMAIL_TESTOID, CORRECT_PASSWORD_TESTOID)
                .waitForSuccessfulLogin();
        page = mailPage.composeClick();
        page.sendMessage(CORRECT_EMAIL_TEST, SUBJECT, TEXT)
                .waitForSuccessfullSending()
                .logout();
        mailPage = loginPage.Login(CORRECT_EMAIL_TEST, CORRECT_PASSWORD_TEST)
                .waitForSuccessfulLogin();
        mailPage.waitForMessageFrom(NAME, 60);
        Message message1 = mailPage.getMessage();
        mailPage.logout();
        mailPage = loginPage.Login(CORRECT_EMAIL_TESTEROVSKI, CORRECT_PASSWORD_TESTEROVSKI)
                .waitForSuccessfulLogin();
        mailPage.waitForMessageFrom(NAME, 30);
        Message message2 = mailPage.getMessage();
        Assert.assertTrue(message1.equalsContent(message2));
    }

    @AfterMethod(groups = MESSAGE)
    @Override
    public void tearDownMethod() {
        mailPage.logout();
        mailPage = loginPage.Login(CORRECT_EMAIL_TEST, CORRECT_PASSWORD_TEST)
                .waitForSuccessfulLogin();
        settings = mailPage.openSettings();
        settings.openForwardingTab();
        settings.removeForwarding();
    }
}
