/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.Group.MESSAGE;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class SengMessageWithIncorrectEmail  extends MessagePreparation{
     SendMessagePage  page ;
    @Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {"autentification"})
     public void sendMessageWithIncorrectEmailtst(){
        
     
     
       page.sendMessage(INCORRECT_EMAIL,SUBJECT, TEXT);
       Assert.assertEquals(page.getAllertTextAndAccept(), INCORRECT_EMAIL_MESSAGE);
      
     
        
     }
    
    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {

        page = mailPage.composeClick();
       
    }
    @AfterMethod(groups = MESSAGE)
     @Override
  public void tearDownMethod(){
     page.closeAndSave();
  }
}
