/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.SpamPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class ReportSpam extends MessagePreparation {

    @Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {
        mailPage.selectMessage();
        Message inputMessage = mailPage.getMessage();
        mailPage.reportSpam();
        SpamPage spamPage = mailPage.goToSpamPage();
        Assert.assertTrue(inputMessage.equals(spamPage.getMessage()));
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(CORRECT_EMAIL_TEST, SUBJECT, TEXT)
                .waitForSuccessfullSending()
                .reload();

    }
}
