/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.Group.AUTENTIFICATION;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */

public class AutentificationWithInvalidPassword extends FirefoxTests implements  TestData, Group{
 
    
    
    @Test(enabled=true, groups = {AUTENTIFICATION})
     public  static void autentificationFailedtst(){
       
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open(START_URL);
           loginPage.Login(CORRECT_EMAIL_TEST, INCORRECT_PASSWORD_TEST); 
       Assert.assertEquals(loginPage.getErrorPasswordMessage(), MESSAGE_INCORRECT_PASSWORD_OR_EMAIL);
     }
}
