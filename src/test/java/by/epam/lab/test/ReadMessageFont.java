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
public class ReadMessageFont extends  MessagePreparation{
    
     @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {


     
        mailPage.openMessage().inboxClick().getMessageAddressee().getCssValue("font-weight");
        Assert.assertEquals( mailPage.openMessage()
                .inboxClick()
                .getMessageAddressee()
                .getCssValue("font-weight"), TestData.NORMAL);
      
    }
             
@BeforeMethod(groups = Group.MESSAGE)
    @Override
    public void tearUpMethod() {

         SendMessagePage page = mailPage.composeClick();
        page.sendMessage(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, TestData.TEXT)
                .waitForSuccessfullSending()
              .reload();

    }
}
