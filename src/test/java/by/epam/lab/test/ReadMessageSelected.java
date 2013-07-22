/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.AllMailPage;
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
public class ReadMessageSelected extends MessagePreparation{
     @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {


       
         mailPage.selectRead();
        Assert.assertTrue( mailPage.checkReadMessageSelected());




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
