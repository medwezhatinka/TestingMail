/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.SendMessagePage;
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

    @Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {"autentification"})
    public void allertDialogMessageAssertion() {
        SendMessagePage page = mailPage
                .composeClick();
        page.createMessageWithAttachedFile(CORRECT_EMAIL_TEST, SUBJECT,
                TEXT, SCRIPT_PATH, attachFile);
        Assert.assertEquals(LARGE_FILE_MESSAGE, page.getAllertTextandClose());
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        attachFile = new File(LARGE_FILE_PATH);
    }
}
