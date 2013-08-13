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
import static by.epam.lab.test.preparation.BasePreparation.log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class DeleteFunction extends MessagePreparation {

    @Test(enabled = true, groups = {MESSAGE})
    public void deleteSelectedMessage() {

        mailPage.selectMessage();
        Message inputMessage = mailPage.getMessage();
        log.info(inputMessage.toString());
        mailPage.deleteMessage();
        MailTablePage trashPage = mailPage.goToTrashPage();
        Message moveMessage = trashPage.getMessage();
        log.info(moveMessage.toString());
        Assert.assertTrue(inputMessage.equals(moveMessage));
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        SendMessage.sendCorrectMessage(mailPage,
                data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT), data.get(Key.TEXT));
    }
}
