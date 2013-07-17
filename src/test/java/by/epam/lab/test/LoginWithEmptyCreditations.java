/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class LoginWithEmptyCreditations extends FirefoxTests{
     @Test(enabled=true, groups = {"autentification"})
     public   void autentificationFailedtst(){
       
       loginPage = new LoginPage(firefox);
       loginPage.open(TestData.HOME_PAGE_URL);
      loginPage.loginClick();
       Assert.assertEquals(loginPage.getErrorEmailMessage(), "Enter your email address.");
 
     }
}
