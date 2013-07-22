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
public class SengMessageWithIncorrectEmail  extends MessagePreparation{
     SendMessagePage  page ;
    @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
     public void sendMessageWithIncorrectEmailtst(){
        
     
     
       page.sendMessage(TestData.INCORRECT_EMAIL,TestData.SUBJECT, TestData.TEXT);
       Assert.assertEquals(page.getAllertTextAndAccept(), TestData.INCORRECT_EMAIL_MESSAGE);
       page.closeAndSave();
     
        
     }
    
    @BeforeMethod(groups = Group.MESSAGE)
    @Override
    public void tearUpMethod() {

        page = mailPage.composeClick();
       
    }
}
