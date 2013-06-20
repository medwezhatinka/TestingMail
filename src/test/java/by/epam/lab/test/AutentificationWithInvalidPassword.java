/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class AutentificationWithInvalidPassword extends FirefoxTests{
 
    
    
    @Test(enabled=false)
     public void autentificationFailedtst(){
       
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab123"); 
       Assert.assertEquals(loginPage.getErrorPasswordMessage(), 
  "The username or password you entered is incorrect. ?");
     }
}
