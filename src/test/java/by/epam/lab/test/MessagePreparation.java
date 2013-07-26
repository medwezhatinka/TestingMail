/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.FirefoxTests.driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Alina_Shumel
 */
public class MessagePreparation extends FirefoxTests {

    @BeforeClass(groups = MESSAGE)
    public void tearUpClass() {
        loginPage = new LoginPage(driver);
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
