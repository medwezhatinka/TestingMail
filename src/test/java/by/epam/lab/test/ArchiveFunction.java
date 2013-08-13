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
public class ArchiveFunction extends MessagePreparation {

    Message inputMessage;

    @Test(enabled = true, groups = {MESSAGE})
    public void sendTextMessagests() {
        log.info(inputMessage.toString());
        mailPage.archiveMessage();
        MailTablePage allMailPage = mailPage.goToAllMailPage();
        Message moveMessage = allMailPage.getMessage();
        log.info(moveMessage.toString());
        Assert.assertTrue(inputMessage.equals(moveMessage));
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        SendMessage.sendCorrectMessage(mailPage, data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT), data.get(Key.TEXT));
        mailPage.selectMessage();
        inputMessage = mailPage.getMessage();
    }
}
