/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import junit.framework.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AutentificationSuccessful extends LoginPreparation {

    @AfterClass(groups = AUTENTIFICATION)
    @Override
    public void tearDownClass() {
        mailPage.logout();
    }

    @Test(enabled = true, groups = {AUTENTIFICATION})
    public void autorization() {

        mailPage = loginPage
                .Login(CORRECT_EMAIL_PART_TEST, CORRECT_PASSWORD_TEST)
                .waitForSuccessfulLogin();
        Assert.assertTrue(mailPage.getLocation().contains(MAIL_PAGE_LOCATION));

    }
}
