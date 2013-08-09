/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.preparation.LoginPreparation;
import static by.epam.lab.test.datareader.TestData.data;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AutentificationWithInvalidPassword extends LoginPreparation {

    @Test(enabled = true, groups = {AUTENTIFICATION})
    public void autentificationFailedtst() {

        loginPage.Login(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.INCORRECT_PASSWORD_TEST));
        Assert.assertEquals(loginPage.getErrorPasswordMessage(),
                data.get(Key.MESSAGE_INCORRECT_PASSWORD_OR_EMAIL));

    }
}
