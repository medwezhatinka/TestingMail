/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.preparation;

import by.epam.lab.driver.Driver;
import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.preparation.BasePreparation.log;
import static by.epam.lab.test.datareader.TestData.data;
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
        loginPage = new LoginPage(Driver.getDriver());
        loginPage.open(data.get(Key.HOME_PAGE_URL));
        mailPage = loginPage.Login(data.get(Key.CORRECT_EMAIL_TEST), data.get(Key.CORRECT_PASSWORD_TEST))
                .waitForSuccessfulLogin();
    }

    @AfterClass(groups = MESSAGE)
    public void tearDownClass() {
        mailPage.logout();
    }

    @BeforeMethod(groups = MESSAGE)
    public void tearUpMethod() {
        log.info("Before method run");
    }

    @AfterMethod(groups = MESSAGE)
    public void tearDownMethod() {
       log.info("After method run");
    }
}
