/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class LoginWithEmptyUsername extends FirefoxTests{
    @Test(enabled=true, groups = {"autentification"})
     public   void autentificationFailedtst(){
       
       loginPage = new LoginPage(firefox);
       loginPage.open(TestData.HOME_PAGE_URL);
       loginPage.inputPassword(TestData.CORRECT_PASSWORD_TEST)
               .loginClick();
     
       Assert.assertEquals(loginPage.getErrorEmailMessage(), "Enter your email address.");
 
     }

}
