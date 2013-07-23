/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.SendMessagePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class SendMessageWithEmptyEmail extends MessagePreparation{
 
     @Test(enabled = true, groups = {MESSAGE})//,dependsOnGroups = { "autentification"})
     public void sendMessageWithEmptyEmailtst(){
        
   
       SendMessagePage  page =  mailPage.composeClick();
       page.sendMessageWithoutAdresse(CORRECT_EMAIL_TEST, TEXT);
       Assert.assertEquals(page.getAllertTextAndAccept(), NO_RECIPIENT_MESSAGE);

     }
}
