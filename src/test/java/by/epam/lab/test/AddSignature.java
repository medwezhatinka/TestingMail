/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.OpenedMessage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.Settings;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
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

    @Test(enabled = true, groups = {Group.MESSAGE})//, dependsOnGroups = {"autentification"})
    public void signAdd() {




        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, TestData.TEXT)
                .waitForSuccessfullSending()
                .reload();
        mailPage.openMessage();
        OpenedMessage openedMessage = new OpenedMessage(firefox);
        Assert.assertEquals(openedMessage.getSignatureText(), TestData.SIGNATURE);


    }

    @BeforeMethod(groups = Group.MESSAGE)
    @Override
    public void tearUpMethod() {

        settings = mailPage.openSettings();
        settings.addSignature(TestData.SIGNATURE)
                .save_changes();

    }

    @AfterMethod(groups = Group.MESSAGE)
    @Override
    public void tearDownMethod() {

        mailPage.inboxClick();
        settings = mailPage.openSettings();
        settings.deleteSignature()
                .save_changes();


    }
}
