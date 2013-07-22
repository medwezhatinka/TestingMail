/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class LoginWithEmptyUsername extends LoginPreparation {

    @Test(enabled = true, groups = {Group.AUTENTIFICATION})
    public void autentificationFailedtst() {

        loginPage.inputPassword(TestData.CORRECT_PASSWORD_TEST)
                .loginClick();

        Assert.assertEquals(loginPage.getErrorEmailMessage(), TestData.ENTER_EMAIL_MESSAGE);

    }
}
