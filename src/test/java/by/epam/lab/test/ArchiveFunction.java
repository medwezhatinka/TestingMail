/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.AllMailPage;
import by.epam.lab.page.Mail;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class ArchiveFunction extends  FirefoxTests{
    @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {


        SendMessagePage page = mailPage.composeClick();
        
       
        page.sendMessage(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, TestData.TEXT)
                .waitForSuccessfullSending()
                .reload();
        mailPage.selectMessage();
        


        Message inputMessage = mailPage.getMessage();
        System.out.println(inputMessage.toString());
        mailPage.archiveMessage();
        
        
        

        AllMailPage allMailPage = mailPage.goToAllMailPage();

         
       
        Message moveMessage = allMailPage.getMessage();
        System.out.println(moveMessage.toString());
        Assert.assertTrue(inputMessage.equals(moveMessage));




    }
}
