/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.datareader.TestData.data;
import java.io.File;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class SendMessageWithAttachedFile extends MessagePreparation {

    @Test(enabled = true, groups = {MESSAGE})
    public void sendMessageWithAttachedFile() throws InterruptedException {
        File attachFile = new File(data.get(Key.SMALL_FILE_PATH));
        SendMessagePage page = mailPage
                .composeClick();
        page.createMessageWithAttachedFile(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT),
                data.get(Key.TEXT), data.get(Key.SCRIPT_PATH), attachFile)
                .waitforsuccessfulAttach(attachFile)
                .send()
                .waitForSuccessfullSending()
                .reload();
        org.testng.Assert.assertEquals(mailPage.getMessageAddressee().getText(), data.get(Key.ME));
    }
}
