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

public class AutentificationSuccessful extends FirefoxTests implements TestData, Group{
    
    
  @Test(enabled=true,groups =AUTENTIFICATION , dataProviderClass = by.epam.lab.test.Data.class)
     public static void autentificationSuccesfulltst(String email, String password, String location) {
      
      LoginPage loginPage = new LoginPage(firefox);
      loginPage.open(START_URL);
      MailPage mailPage = loginPage.Login(email, password).waitForSuccessfulLogin();
      Assert.assertTrue(mailPage.getLocation().contains(location), "location : " + mailPage.getLocation());
      mailPage.logout();
 
      }   
    
}
