/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.datareader.TestData;
import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.Group.AUTENTIFICATION;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class LogoutSuccessfull  extends FirefoxTests {
    
    
    
    @Test(enabled=true, groups = {AUTENTIFICATION})//, dependsOnMethods = {"by.epam.lab.test.AutentificationSuccessfull.autentificationSuccesfulltst"})
     public   void logoutSuccessfultst(){
    
      loginPage = new LoginPage(firefox);
       loginPage.open(TestData.START_URL);
        mailPage = loginPage.Login(TestData.CORRECT_EMAIL_TEST, TestData.CORRECT_PASSWORD_TEST).waitForSuccessfulLogin(); 
       mailPage.logout();
       Assert.assertTrue(mailPage.getLocation().contains(TestData.MAIL_PAGE_LOCATION), "location : " + mailPage.getLocation());
      
     }
}
