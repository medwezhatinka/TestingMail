/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.AllMailPage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.test.datareader.TestData;
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

    @Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {
        log.info(inputMessage.toString());
        mailPage.archiveMessage();
        AllMailPage allMailPage = mailPage.goToAllMailPage();
        Message moveMessage = allMailPage.getMessage();
        log.info(moveMessage.toString());
        Assert.assertTrue(inputMessage.equals(moveMessage));
        
        
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, TestData.TEXT)
                .waitForSuccessfullSending()
                .reload();
        mailPage.selectMessage();
        inputMessage = mailPage.getMessage();
    }
}
