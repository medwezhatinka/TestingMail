/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.Group.AUTENTIFICATION;
import by.epam.lab.test.datareader.TestData;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
 
public class SendMessageWithAttachedFile extends FirefoxTests {
    
   @Test(enabled= true, groups = {"send text"})//, dependsOnGroups = {AUTENTIFICATION}, description = "not ready")
     public void sendMessageWithAttachedFile() throws InterruptedException{
         
       loginPage = new LoginPage(firefox);
       loginPage.open(TestData.START_URL);
       SendMessagePage  page = loginPage
               .Login(TestData.CORRECT_EMAIL_TEST, TestData.CORRECT_PASSWORD_TEST).waitForSuccessfulLogin()
               .composeClick();
       page.sendMessageWithAttachedFile("test.auto.lab@gmail.com", "subject", "some text", "\"C:\\Documents and Settings\\Alina_Shumel\\My Documents\\NetBeansProjects\\TestingMail\\pic\\trash.png\"");
      
       
       //mailPage.logout();
         
     }
}
