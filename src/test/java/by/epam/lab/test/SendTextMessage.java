/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.FirefoxTests.firefox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */

public class SendTextMessage extends FirefoxTests {
    
@Test(enabled = true, groups = {"send text"})//, dependsOnGroups = {"autentification"})
    public void sendTextMessagests() {


        SendMessagePage page = mailPage.composeClick();
        page.sendMessage("test.auto.lab@gmail.com", "subject", "some text")
                .waitForSuccessfullSending()
                .reload();
        Assert.assertEquals(mailPage.getMessageAddressee(), "me");
      
    }
}
