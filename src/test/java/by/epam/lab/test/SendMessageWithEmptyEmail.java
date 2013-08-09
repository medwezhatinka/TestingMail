/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.preparation.MessagePreparation;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.datareader.TestData.data;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class SendMessageWithEmptyEmail extends MessagePreparation {

    @Test(enabled = true, groups = {MESSAGE})
    public void sendMessageWithEmptyEmailtst() {


        SendMessagePage page = mailPage.composeClick();
        page.sendMessageWithoutAdresse(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.TEXT));
        Assert.assertEquals(page.getAllertTextAndAccept(), data.get(Key.NO_RECIPIENT_MESSAGE));

    }
}
