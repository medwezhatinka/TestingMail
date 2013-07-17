/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.Logic;
import by.epam.lab.page.OpenedMessage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.Settings;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AddForwarding extends FirefoxTests {

    @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void signAdd() throws InterruptedException, Exception {



        mailPage.openSettings();


        Settings settings = new Settings(firefox);
        settings.openForwardingTab();

        settings.addForwardingAddress("medwezhatinka@gmail.com");
        mailPage.logout();
        mailPage = loginPage.Login("medwezhatinka@gmail.com", "559283medwedik").waitForSuccessfulLogin();
        mailPage.openMessage();
        OpenedMessage openedMessage = new OpenedMessage(firefox);
        String code = Logic.substringAfter(openedMessage.getMessageText(), "Confirmation code:", 8);
        mailPage.logout();
        mailPage = loginPage.Login(TestData.CORRECT_EMAIL_TEST, TestData.CORRECT_PASSWORD_TEST).waitForSuccessfulLogin();
        mailPage.openSettings();


        settings = new Settings(firefox);
        settings.openForwardingTab();
        settings.verifyCode(code);

        settings.forwardOn();


        mailPage.logout();
        mailPage = loginPage.Login("testoid2013@gmail.com", "559283test").waitForSuccessfulLogin();
        SendMessagePage page = mailPage.composeClick();

        page.sendMessage(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, TestData.TEXT)
                .waitForSuccessfullSending()
                .logout();

        
        mailPage = loginPage.Login("test.auto.lab@gmail.com", "testautolab").waitForSuccessfulLogin();
        
        mailPage.waitForMessageFrom("test test", 40);
        Message message1 = mailPage.getMessage();
        

        mailPage.logout();
        mailPage = loginPage.Login("medwezhatinka@gmail.com", "559283medwedik").waitForSuccessfulLogin();
        mailPage.waitForMessageFrom("test test", 20);
        Message message2 = mailPage.getMessage();
        Assert.assertTrue(message1.equalsContent(message2));




    }
}
