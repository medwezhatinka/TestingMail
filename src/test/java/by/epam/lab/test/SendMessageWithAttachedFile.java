/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.test.datareader.TestData;
import java.io.File;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class SendMessageWithAttachedFile extends MessagePreparation {

    @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {AUTENTIFICATION}, description = "not ready")
    public void sendMessageWithAttachedFile() throws InterruptedException {
        File attachFile = new File(TestData.SMALL_FILE_PATH);
    

        SendMessagePage page = mailPage
                .composeClick();
        page.createMessageWithAttachedFile(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT,
                TestData.TEXT, TestData.SCRIPT_PATH, attachFile)
                .waitforsuccessfulAttach(attachFile)
                .send()
                .waitForSuccessfullSending()
                .reload();

        org.testng.Assert.assertEquals(mailPage.getMessageAddressee().getText(), TestData.ME);


    

    }
}
