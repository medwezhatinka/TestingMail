/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testimgmail;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import static com.mycompany.testimgmail.FirefoxTests.firefox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class Tests extends FirefoxTests{
    
    
    
    public Tests() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   // @BeforeTest
    
     @Test
     public void autentificationSuccesfull() {
          
      
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab");
       MailPage mailPage = new  MailPage(firefox);
       Assert.assertTrue(mailPage.getLocation().contains("https://mail.google.com/mail/"), "title : " + mailPage.getLocation());
        WebDriverWait wait = new WebDriverWait(firefox, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gbg4")));
        mailPage.Logout();
           }   
     
     @Test
     public void autentificationFailed(){
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab123"); 
       Assert.assertEquals(loginPage.getErrorPasswordMessage(), 
  "The username or password you entered is incorrect. ?");
     }
}