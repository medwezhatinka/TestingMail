/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author Alina_Shumel
 */
public class LoginPreparation extends FirefoxTests {

    @BeforeClass(groups = Group.AUTENTIFICATION)
    public void tearUpClass() {
        loginPage = new LoginPage(firefox);
        loginPage.open(TestData.HOME_PAGE_URL);

    }
     @AfterClass(groups = Group.AUTENTIFICATION)
  public void tearDownClass(){
  /*
   * nothing to do
   * before/after class not work 
   * without override annotation
   */
        
    }
}
