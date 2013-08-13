/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.logic.SendMessage;
import by.epam.lab.test.preparation.MessagePreparation;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.Group.MESSAGE;
import static by.epam.lab.test.datareader.TestData.data;
import static by.epam.lab.test.preparation.BasePreparation.log;
import java.io.File;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class SendMessageWithAttachedFile extends MessagePreparation {

    File attachFile;

    @Test(enabled = true, groups = {MESSAGE})
    public void sendMessageWithAttachedFile() throws InterruptedException {
        SendMessage.sendMessageWithAttach(mailPage, data.get(Key.CORRECT_EMAIL_TEST),
                data.get(Key.SUBJECT), data.get(Key.TEXT), data.get(Key.SCRIPT_PATH), attachFile);
        Assert.assertEquals(mailPage.getMessageAddressee().getText(), data.get(Key.ME));
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        attachFile = new File(data.get(Key.SMALL_FILE_PATH));
    }
}
