/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.preparation;

import by.epam.lab.driver.Driver;
import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.datareader.TestData.data;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class LoginPreparation extends BasePreparation {

    @BeforeClass(groups = AUTENTIFICATION)
    public void tearUpClass() {
        loginPage = new LoginPage(Driver.getDriver());
        loginPage.open(data.get(Key.HOME_PAGE_URL));
    }

    @AfterClass(groups = AUTENTIFICATION)
    public void tearDownClass() {
        log.info("After class run");
    }
}
