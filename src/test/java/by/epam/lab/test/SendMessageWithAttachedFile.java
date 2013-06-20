/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import by.epam.lab.page.SendMessagePage;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */

public class SendMessageWithAttachedFile extends FirefoxTests{
    
    @Test(enabled= false, groups = {"attach file"}, dependsOnGroups = {"autentification"})
     public void sendMessageWithAttachedFile(){
         
         LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       SendMessagePage  page = loginPage
               .Login("test.auto.lab@gmail.com", "testautolab")
               .composeClick();
       page.sendMessageWithAttachedFile("test.auto.lab@gmail.com", "subject", "some text", "../pic/trash.png");
      
       
       //mailPage.logout();
         
     }
}
