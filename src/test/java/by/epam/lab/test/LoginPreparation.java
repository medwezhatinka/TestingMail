/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.FirefoxTests.driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author Alina_Shumel
 */
public class LoginPreparation extends FirefoxTests {

    @BeforeClass(groups =AUTENTIFICATION)
    public void tearUpClass() {
        loginPage = new LoginPage(driver);
        loginPage.open(HOME_PAGE_URL);

    }
     @AfterClass(groups = AUTENTIFICATION)
  public void tearDownClass(){
  /*
   * nothing to do
   * before/after class not work 
   * without override annotation
   */
        
    }
}
