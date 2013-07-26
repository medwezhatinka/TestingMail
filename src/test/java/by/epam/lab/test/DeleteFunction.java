/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.TrashPage;
import static by.epam.lab.test.FirefoxTests.log;
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

    @Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {"autentification"})
    public void deleteSelectedMessage() {
        
        mailPage.selectMessage();
        Message inputMessage = mailPage.getMessage();
         log.info(inputMessage.toString());
        mailPage.deleteMessage();
        TrashPage trashPage = mailPage.goToTrashPage();
        Message moveMessage = trashPage.getMessage();
         log.info(moveMessage.toString());
        Assert.assertTrue(inputMessage.equals(moveMessage));
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
