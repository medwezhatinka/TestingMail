/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.logic.SendMessage;
import by.epam.lab.test.preparation.MessagePreparation;
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
public class CheckOptions extends MessagePreparation {

    @Test(enabled = true, groups = {MESSAGE})
    public void messageOptionsDisplayed() {
        mailPage.selectMessage();
        Assert.assertTrue(mailPage.optionsPresent());
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        SendMessage.sendCorrectMessage(mailPage,
                data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.SUBJECT), data.get(Key.TEXT));
    }
}
