/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.Group.AUTENTIFICATION;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
 
public class SendMessageWithAttachedFile extends FirefoxTests implements TestData, Group{
    
   @Test(enabled= false, groups = {}, dependsOnGroups = {AUTENTIFICATION})
     public void sendMessageWithAttachedFile(){
         
         LoginPage loginPage = new LoginPage(firefox);
       loginPage.open(START_URL);
       SendMessagePage  page = loginPage
               .Login(CORRECT_EMAIL_TEST, CORRECT_PASSWORD_TEST).waitForSuccessfulLogin()
               .composeClick();
       page.sendMessageWithAttachedFile("test.auto.lab@gmail.com", "subject", "some text", "../pic/trash.png");
      
       
       //mailPage.logout();
         
     }
}
