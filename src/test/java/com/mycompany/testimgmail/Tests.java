/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testimgmail;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import static com.mycompany.testimgmail.FirefoxTests.firefox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    
     @Test(enabled=false)
     public void autentificationSuccesfull() {
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab");
       MailPage mailPage = new  MailPage(firefox);
       Assert.assertTrue(mailPage.getLocation().contains("https://mail.google.com/mail/"), "title : " + mailPage.getLocation());
        mailPage.Logout();
           }   
     
     @Test(enabled=false)
     public void autentificationFailed(){
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab123"); 
       Assert.assertEquals(loginPage.getErrorPasswordMessage(), 
  "The username or password you entered is incorrect. ?");
     }
     
     @Test(enabled=true)
     public void  sendTextMessage(){
         LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab");
       MailPage mailPage = new  MailPage(firefox);
       
       mailPage.waitfor("//div[text()='COMPOSE']");
       WebElement composeButton = mailPage.findByXpath("//div[text()='COMPOSE']");
         composeButton.click();
     }
     @Test
     public void sendMessageWithEmptyEmail(){
         
     }
     @Test
     public void sendMessageWithAttachedFile(){
         
     }
}