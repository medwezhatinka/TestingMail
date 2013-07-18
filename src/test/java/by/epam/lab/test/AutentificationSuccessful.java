/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.datareader.TestData;
import by.epam.lab.page.LoginPage;
import junit.framework.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AutentificationSuccessful extends FirefoxTests {
  
   
    
    @Test(enabled = true, groups = {"autentification"})
    public void autorization(){
        
        loginPage = new LoginPage(firefox);
        loginPage.open(TestData.HOME_PAGE_URL);
        mailPage = loginPage.Login(TestData.CORRECT_EMAIL_PART_TEST, TestData.CORRECT_PASSWORD_TEST)
                .waitForSuccessfulLogin();
        Assert.assertTrue(mailPage.getLocation().contains(TestData.MAIL_PAGE_LOCATION));
        mailPage.logout();
    }
}
