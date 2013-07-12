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
public class AddForwarding extends FirefoxTests{
    
     @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void signAdd() {
        
      
       
        mailPage.openSettings();
        
       
      Settings settings = new Settings(firefox);
       settings.openForwardingTab();
       
    }
    
}
