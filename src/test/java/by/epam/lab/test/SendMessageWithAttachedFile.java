/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.Group.AUTENTIFICATION;
import by.epam.lab.test.datareader.TestData;
import org.junit.Assert;
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
      mailPage = loginPage
               .Login(TestData.CORRECT_EMAIL_TEST, TestData.CORRECT_PASSWORD_TEST).waitForSuccessfulLogin();
       
       SendMessagePage  page = mailPage
               .composeClick();
       page.sendMessageWithAttachedFile(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, 
               TestData.TEXT, TestData.SCRIPT_PATH,TestData.SMALL_FILE_PATH)
               .waitForSuccessfullSending()
               .reload();
       
      org.testng.Assert.assertEquals(mailPage.getMessageAddressee(), TestData.ME);
      
       
       mailPage.logout();
         
     }
}
