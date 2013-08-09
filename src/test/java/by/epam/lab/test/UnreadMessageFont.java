/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

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
public class UnreadMessageFont extends MessagePreparation {

    SendMessagePage page;

    @Test(enabled = true, groups = {MESSAGE})
    public void checkUnreadMessageFont() {
        page.sendMessage(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT), data.get(Key.TEXT))
                .waitForSuccessfullSending()
                .reload();
        Assert.assertEquals(mailPage.getMessageAddressee().getCssValue(data.get(Key.FONT_WEIGHT)), data.get(Key.BOLD));

    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        page = mailPage.composeClick();
    }
}
