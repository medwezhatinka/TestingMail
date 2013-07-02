/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */

public class AutentificationWithInvalidPassword extends FirefoxTests {
 
    
    
    @Test(enabled=true, groups = {"autentification"})
     public   void autentificationFailedtst(){
       
       loginPage = new LoginPage(firefox);
       loginPage.open(TestData.HOME_PAGE_URL);
      loginPage.Login(TestData.CORRECT_EMAIL_TEST, TestData.INCORRECT_PASSWORD_TEST); 
       Assert.assertEquals(loginPage.getErrorPasswordMessage(), TestData.MESSAGE_INCORRECT_PASSWORD_OR_EMAIL);
 
     }
}
