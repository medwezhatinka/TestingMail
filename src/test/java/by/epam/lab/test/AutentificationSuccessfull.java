/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class AutentificationSuccessfull extends FirefoxTests{
    
    
     @Test(enabled=false)
     public void autentificationSuccesfulltst() {
      
      LoginPage loginPage = new LoginPage(firefox);
      loginPage.open("http://mail.google.com");
      MailPage mailPage = loginPage.Login("test.auto.lab", "testautolab");
      Assert.assertTrue(mailPage.getLocation().contains("https://mail.google.com/mail/"), "location : " + mailPage.getLocation());
      mailPage.logout();
 
      }   
    
}
