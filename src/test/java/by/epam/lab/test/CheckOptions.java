/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.SendMessagePage;
import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class CheckOptions extends FirefoxTests{
    
    
    @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {


        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT, TestData.TEXT)
                .waitForSuccessfullSending()
                .inboxClick();
        
              
          long time1= System.currentTimeMillis()+5000;
        while(time1> System.currentTimeMillis()){}
      mailPage.selectMessage();
        
        
        long time= System.currentTimeMillis()+10000;
        while(time> System.currentTimeMillis()){}
      
      
    }
}
