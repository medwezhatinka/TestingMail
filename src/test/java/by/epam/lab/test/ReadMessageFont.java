/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.preparation.MessagePreparation;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.datareader.TestData.data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class ReadMessageFont extends MessagePreparation {

    @Test(enabled = true, groups = {MESSAGE})
    public void chechReadMessageFont() {
        mailPage.openMessage().inboxClick().getMessageAddressee().getCssValue(data.get(Key.FONT_WEIGHT));
        Assert.assertEquals(mailPage.openMessage()
                .inboxClick()
                .getMessageAddressee()
                .getCssValue(data.get(Key.FONT_WEIGHT)), data.get(Key.NORMAL));
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT), data.get(Key.TEXT))
                .waitForSuccessfullSending()
                .reload();

    }
}
