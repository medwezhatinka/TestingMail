/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.preparation.MessagePreparation;
import by.epam.lab.element.message.Message;
import by.epam.lab.logic.SendMessage;
import by.epam.lab.page.MailTablePage;
import static by.epam.lab.test.datareader.TestData.data;
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

    @Test(enabled = true, groups = {MESSAGE})
    public void reportSpam() {
        mailPage.selectMessage();
        Message inputMessage = mailPage.getMessage();
        log.info(inputMessage.toString());
        mailPage.reportSpam();
        MailTablePage spamPage = mailPage.goToSpamPage();
        log.info(spamPage.getMessage());
        Assert.assertTrue(inputMessage.equals(spamPage.getMessage()));

    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        SendMessage.sendCorrectMessage(mailPage, 
                data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT), data.get(Key.TEXT));

    }
}
