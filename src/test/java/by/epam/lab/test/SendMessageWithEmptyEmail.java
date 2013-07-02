/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */

public class SendMessageWithEmptyEmail extends FirefoxTests{
 
     @Test(enabled = true, groups = {"message"})//,dependsOnGroups = { "autentification"})
     public void sendMessageWithEmptyEmailtst(){
        
   
       SendMessagePage  page =  mailPage.composeClick();
       page.sendMessageWithoutAdresse(TestData.CORRECT_EMAIL_TEST, TestData.TEXT);
       Assert.assertEquals(page.getAllertTextAndAccept(), TestData.NO_RECIPIENT_MESSAGE);

     }
}
