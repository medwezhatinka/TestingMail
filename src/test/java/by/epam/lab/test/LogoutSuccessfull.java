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
public class LogoutSuccessfull  extends FirefoxTests{
    
    @Test(enabled=false, groups = {"autentification"}, dependsOnMethods = {"autentificationSuccesfulltst"})
     public void logoutSuccessfultst(){
    
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab"); 
       MailPage mailPage = loginPage.Login("test.auto.lab@gmail.com", "testautolab"); 
       mailPage.logout();
       Assert.assertTrue(mailPage.getLocation().contains("https://accounts.google.com/ServiceLogin"), "location : " + mailPage.getLocation());
      
     }
}
