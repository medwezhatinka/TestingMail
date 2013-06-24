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
@Test(enabled=true,groups =AUTENTIFICATION )
public class AutentificationSuccessfull extends FirefoxTests implements TestData, Group{
    
    
  
     public static void autentificationSuccesfulltst() {
      
      LoginPage loginPage = new LoginPage(firefox);
      loginPage.open(START_URL);
      MailPage mailPage = loginPage.Login(CORRECT_EMAIL_PART_TEST, CORRECT_PASSWORD_TEST).waitForSuccessfulLogin();
      Assert.assertTrue(mailPage.getLocation().contains(MAIL_PAGE_LOCATION), "location : " + mailPage.getLocation());
      mailPage.logout();
 
      }   
    
}
