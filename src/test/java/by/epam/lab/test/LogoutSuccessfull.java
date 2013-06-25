/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import static by.epam.lab.test.Group.AUTENTIFICATION;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */

public class LogoutSuccessfull  extends FirefoxTests implements  TestData{
    
    @Test(enabled=true, groups = {AUTENTIFICATION}, dependsOnMethods = {"by.epam.lab.test.AutentificationSuccessfull.autentificationSuccesfulltst"})
     public  static void logoutSuccessfultst(){
    
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open(START_URL);
       MailPage mailPage = loginPage.Login(CORRECT_EMAIL_TEST, CORRECT_PASSWORD_TEST).waitForSuccessfulLogin(); 
       mailPage.logout();
       Assert.assertTrue(mailPage.getLocation().contains(LOGIN_PAGE_LOCATION), "location : " + mailPage.getLocation());
      
     }
}
