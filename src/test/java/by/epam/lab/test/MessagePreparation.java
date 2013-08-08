/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class MessagePreparation extends BasePreparation {

    @BeforeClass(groups = MESSAGE)
    public void tearUpClass() {
        loginPage = new LoginPage(getDriver());
        loginPage.open(HOME_PAGE_URL);
        mailPage = loginPage.Login(CORRECT_EMAIL_TEST, CORRECT_PASSWORD_TEST)
                .waitForSuccessfulLogin();
    }

    @AfterClass(groups = MESSAGE)
    public void tearDownClass() {
        mailPage.logout();
    }

    @BeforeMethod(groups = MESSAGE)
    public void tearUpMethod() {
        /*
         * 
         */
    }

    @AfterMethod(groups = MESSAGE)
    public void tearDownMethod() {
        /*
         * 
         */
    }
}
