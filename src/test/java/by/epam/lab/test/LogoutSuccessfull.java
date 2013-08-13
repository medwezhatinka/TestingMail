/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.preparation.LoginPreparation;
import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.datareader.TestData.data;
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

    @Test(enabled = true, groups = {AUTENTIFICATION})
    public void logoutSuccessfultst() {
        mailPage.logout();
        Assert.assertTrue(mailPage.getLocation().contains(data.get(Key.MAIL_PAGE_LOCATION)), "location : " + mailPage.getLocation());
    }

    @BeforeClass(groups = Group.AUTENTIFICATION)
    @Override
    public void tearUpClass() {
        loginPage = new LoginPage();
        loginPage.open(data.get(Key.HOME_PAGE_URL));
        mailPage = loginPage
                .Login(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.CORRECT_PASSWORD_TEST))
                .waitForSuccessfulLogin();
    }
}
