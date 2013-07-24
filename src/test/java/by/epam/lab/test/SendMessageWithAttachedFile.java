/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.SendMessagePage;
import java.io.File;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class SendMessageWithAttachedFile extends MessagePreparation {

    @Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {AUTENTIFICATION}, description = "not ready")
    public void sendMessageWithAttachedFile() throws InterruptedException {
        File attachFile = new File(SMALL_FILE_PATH);


        SendMessagePage page = mailPage
                .composeClick();
        page.createMessageWithAttachedFile(CORRECT_EMAIL_TEST, SUBJECT,
                TEXT, SCRIPT_PATH, attachFile)
                .waitforsuccessfulAttach(attachFile)
                .send()
                .waitForSuccessfullSending()
                .reload();

        org.testng.Assert.assertEquals(mailPage.getMessageAddressee().getText(), ME);




    }
}
