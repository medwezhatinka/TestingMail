/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.SendMessagePage;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class SendTextMessage extends MessagePreparation {
    
   SendMessagePage  page;
    
@Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {


     
        page.sendMessage(CORRECT_EMAIL_TEST, SUBJECT, TEXT)
                .waitForSuccessfullSending()
                .reload();
        Assert.assertEquals(mailPage.getMessageAddressee().getText(), ME);
      
    }
@BeforeMethod(groups = MESSAGE)
   
    public  void tearUpMethod1() {

        page = mailPage.composeClick();
       
    }
}
