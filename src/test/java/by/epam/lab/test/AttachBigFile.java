/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.preparation.MessagePreparation;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.datareader.TestData.data;
import java.io.File;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AttachBigFile extends MessagePreparation {

    File attachFile;

    @Test(enabled = true, groups = {MESSAGE})
    public void allertDialogMessageAssertion() {
        SendMessagePage page = mailPage
                .composeClick();
        page.createMessageWithAttachedFile(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT),
                data.get(Key.TEXT), data.get(Key.SCRIPT_PATH), attachFile);
        Assert.assertEquals(data.get(Key.LARGE_FILE_MESSAGE), page.getAllertTextandClose());
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        attachFile = new File(data.get(Key.LARGE_FILE_PATH));
    }
}
