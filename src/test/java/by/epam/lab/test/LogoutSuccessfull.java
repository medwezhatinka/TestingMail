/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class LogoutSuccessfull extends LoginPreparation {

    @Test(enabled = true, groups = {AUTENTIFICATION})//, dependsOnMethods = {"by.epam.lab.test.AutentificationSuccessfull.autentificationSuccesfulltst"})
    public void logoutSuccessfultst() {
        mailPage.logout();
        Assert.assertTrue(mailPage.getLocation().contains(MAIL_PAGE_LOCATION), "location : " + mailPage.getLocation());
    }

    @BeforeClass(groups = Group.AUTENTIFICATION)
    @Override
    public void tearUpClass() {
        loginPage = new LoginPage(driver);
        loginPage.open(HOME_PAGE_URL);
        mailPage = loginPage
                .Login(CORRECT_EMAIL_TEST, CORRECT_PASSWORD_TEST)
                .waitForSuccessfulLogin();
    }
}
