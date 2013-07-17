/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.TrashPage;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class DeleteFunction extends FirefoxTests {

    @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {


        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, TestData.TEXT)
                .waitForSuccessfullSending()
                .reload();
        mailPage.selectMessage();


        Message inputMessage = mailPage.getMessage();
        System.out.println(inputMessage.toString());
        mailPage.deleteMessage();
        
        
        

        TrashPage trashPage = mailPage.goToTrashPage();

        
       
        Message moveMessage = trashPage.getMessage();
        System.out.println(moveMessage.toString());
        Assert.assertTrue(inputMessage.equals(moveMessage));




    }
}
