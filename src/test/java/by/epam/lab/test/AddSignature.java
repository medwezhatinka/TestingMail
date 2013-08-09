/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.preparation.MessagePreparation;
import by.epam.lab.page.OpenedMessage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.Settings;
import static by.epam.lab.test.datareader.TestData.data;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AddSignature extends MessagePreparation {

    private Settings settings;

    @Test(enabled = true, groups = {MESSAGE})
    public void signatureAdd() {
        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT), data.get(Key.TEXT))
                .waitForSuccessfullSending()
                .reload();
        mailPage.openMessage();
        OpenedMessage openedMessage = new OpenedMessage(getDriver());
        Assert.assertEquals(openedMessage.getSignatureText(), data.get(Key.SIGNATURE));
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        settings = mailPage.openSettings();
        settings.addSignature(data.get(Key.SIGNATURE))
                .save_changes();
    }

    @AfterMethod(groups = MESSAGE)
    @Override
    public void tearDownMethod() {
        mailPage.inboxClick();
        settings = mailPage.openSettings();
        settings.deleteSignature()
                .save_changes();
    }
}
