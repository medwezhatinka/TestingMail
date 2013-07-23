/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.SendMessagePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class UnreadMessageFont extends MessagePreparation{
         SendMessagePage page;
    @Test(enabled = true, groups = {MESSAGE})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {


       
        page.sendMessage(CORRECT_EMAIL_TEST, SUBJECT, TEXT)
                .waitForSuccessfullSending()
                .reload();
        Assert.assertEquals(mailPage.getMessageAddressee().getCssValue(FONT_WEIGHT), BOLD);
      
    }
    
    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {

    page = mailPage.composeClick();
       

    }
}
