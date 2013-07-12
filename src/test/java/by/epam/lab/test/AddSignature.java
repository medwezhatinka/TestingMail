/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.OpenedMessage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.Settings;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class AddSignature extends FirefoxTests{
    
    @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void signAdd() {
        
      
       
        mailPage.openSettings();
        
       
      Settings settings = new Settings(firefox);
        
        settings.addSignature(TestData.SIGNATURE);
        settings.save_changes();
      
        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, TestData.TEXT)
                .waitForSuccessfullSending()
                .reload();
        mailPage.openMessage(); 
        OpenedMessage openedMessage = new OpenedMessage(firefox);
      Assert.assertEquals(openedMessage.getSignatureText(), TestData.SIGNATURE);  
      
      
      mailPage.inboxClick();
       mailPage.openSettings();
    
         settings = new Settings(firefox);
        
        settings.deleteSignature();
        settings.save_changes();
    }
    

}
