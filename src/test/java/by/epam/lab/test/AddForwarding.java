/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.preparation.MessagePreparation;
import by.epam.lab.element.message.Message;
import by.epam.lab.logic.Forwarding;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.Settings;
import static by.epam.lab.test.datareader.TestData.data;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AddForwarding extends MessagePreparation {

    Settings settings;
    SendMessagePage page;

    @Test(enabled = true, groups = {MESSAGE})
    public void forwarding() throws InterruptedException, Exception {

        loginPage = Forwarding.addEmail(mailPage, data.get(Key.CORRECT_EMAIL_TESTEROVSKI));
        String code = Forwarding.getConfirmationCode(loginPage, data.get(Key.CORRECT_EMAIL_TESTEROVSKI),
                data.get(Key.CORRECT_PASSWORD_TESTEROVSKI), data.get(Key.CONFIRMATION_CODE),
                Integer.valueOf(data.get(Key.CODE_LENGTH)));
        loginPage = Forwarding.verifyCode(loginPage, data.get(Key.CORRECT_EMAIL_TEST),
                data.get(Key.CORRECT_PASSWORD_TEST), code);
        loginPage = Forwarding.sendMessage(loginPage, data.get(Key.CORRECT_EMAIL_TESTOID),
                data.get(Key.CORRECT_PASSWORD_TESTOID), data.get(Key.CORRECT_EMAIL_TEST),
                data.get(Key.SUBJECT), data.get(Key.TEXT));
        Message message1 = Forwarding.checkMessagePresent(loginPage, data.get(Key.CORRECT_EMAIL_TEST),
                data.get(Key.CORRECT_PASSWORD_TEST), data.get(Key.NAME), Integer.valueOf(data.get(Key.WAIT_FOR_MESSAGE)));
        Message message2 = Forwarding.checkMessagePresent(loginPage,
                data.get(Key.CORRECT_EMAIL_TESTEROVSKI), data.get(Key.CORRECT_PASSWORD_TESTEROVSKI),
                data.get(Key.NAME), Integer.valueOf(data.get(Key.WAIT_FOR_MESSAGE)));
        Assert.assertTrue(message1.equalsContent(message2));
    }

    @AfterMethod(groups = MESSAGE)
    @Override
    public void tearDownMethod() {
        Forwarding.removeForwarding(loginPage, data.get(Key.CORRECT_EMAIL_TEST),
                data.get(Key.CORRECT_PASSWORD_TEST));
    }
}
