/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import by.epam.lab.page.SendMessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */

public class SendMessageWithEmptyEmail extends FirefoxTests{
 
     @Test(enabled = true, groups = {"send text"},dependsOnGroups = { "autentification"})
     public void sendMessageWithEmptyEmailtst(){
        
         LoginPage loginPage = new LoginPage(firefox);
      loginPage.open("http://www.gmail.com");
       MailPage mailPage = loginPage.Login("test.auto.lab@gmail.com", "testautolab").waitForSuccessfulLogin();
       SendMessagePage  page =  mailPage.composeClick();
       page.sendMessageWithoutAdresse("subject", "some text");
       Assert.assertEquals(page.getAllertTextAndAccept(), "ErrorPlease specify at least one recipient.");
       mailPage.logout();
     }
}
