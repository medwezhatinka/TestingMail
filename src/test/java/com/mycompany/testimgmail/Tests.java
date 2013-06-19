/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testimgmail;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import by.epam.lab.page.SendMessagePage;
import static com.mycompany.testimgmail.FirefoxTests.firefox;
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
       loginPage.open("http://mail.google.com");
       loginPage.Login("test.auto.lab", "testautolab");
       MailPage mailPage = new  MailPage(firefox);
       Assert.assertTrue(mailPage.getLocation().contains("https://mail.google.com/mail/"), "location : " + mailPage.getLocation());
        mailPage.logout();
           }   
     
     @Test(enabled=false)
     public void autentificationFailed(){
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab123"); 
       Assert.assertEquals(loginPage.getErrorPasswordMessage(), 
  "The username or password you entered is incorrect. ?");
     }
     
      @Test(enabled=false)
     public void logoutSuccessful(){
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab"); 
       MailPage mailPage = new  MailPage(firefox);
       mailPage.logout();
       Assert.assertTrue(mailPage.getLocation().contains("https://accounts.google.com/ServiceLogin"), "location : " + mailPage.getLocation());
      
     }
     
     @Test(enabled=false)
     public void  sendTextMessage(){
         LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab");
       loginPage.waitfor("//div[text()='COMPOSE']");
       MailPage mailPage = new  MailPage(firefox);
       mailPage.composeClick();
       mailPage.waitfor("//table[@class='cf Ht']/tbody/tr/td/div");
       SendMessagePage  page = new SendMessagePage(firefox);
       page.sendMessage("test.auto.lab@gmail.com", "subject", "some text");
       page.waitForSuccessfullSending();
       mailPage.reload();
       Assert.assertEquals(mailPage.getMessageAddressee(), "me");
        mailPage.logout();
     }

     @Test(enabled = false)
     public void sendMessageWithEmptyEmail(){
        
         LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab");
       loginPage.waitfor("//div[text()='COMPOSE']");
       MailPage mailPage = new  MailPage(firefox);
       mailPage.composeClick();
       mailPage.waitfor("//table[@class='cf Ht']/tbody/tr/td/div");
       SendMessagePage  page = new SendMessagePage(firefox);
       page.sendMessageWithoutAdresse("subject", "some text");
       Assert.assertEquals(page.getAllertTextAndAccept(), "ErrorPlease specify at least one recipient.");
       mailPage.logout();
     }
     
     @Test(enabled = false)
     public void sendMessageWithIncorrectEmail(){
        
         LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab");
       loginPage.waitfor("//div[text()='COMPOSE']");
       MailPage mailPage = new  MailPage(firefox);
       mailPage.composeClick();
       mailPage.waitfor("//table[@class='cf Ht']/tbody/tr/td/div");
       SendMessagePage  page = new SendMessagePage(firefox);
       page.sendMessage("incorrect_email","subject", "some text");
       Assert.assertEquals(page.getAllertTextAndAccept(), "ErrorThe address \"incorrect_email\" in the \"To\" field was not recognized. Please make sure that all addresses are properly formed.");
        page.closeAndSave();
        mailPage.logout();
        
     }
     
     @Test(enabled= true)
     public void sendMessageWithAttachedFile(){
         
         LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab");
       loginPage.waitfor("//div[text()='COMPOSE']");
       MailPage mailPage = new  MailPage(firefox);
       mailPage.composeClick();
       mailPage.waitfor("//table[@class='cf Ht']/tbody/tr/td/div");
       SendMessagePage  page = new SendMessagePage(firefox);
       page.sendMessageWithAttachedFile("test.auto.lab@gmail.com", "subject", "some text", "../pic/trash.png");
       mailPage.logout();
         
     }
}