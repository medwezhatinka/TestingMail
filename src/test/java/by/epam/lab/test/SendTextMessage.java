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
  @Test(enabled=true, groups = {"send text"}, dependsOnGroups = {"autentification"})
public class SendTextMessage extends FirefoxTests{
  
       MailPage mailPage;
       SendMessagePage  page;
       
      @BeforeMethod
   public void g(){
           
        LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       
       
     mailPage = loginPage.Login("test.auto.lab@gmail.com", "testautolab").waitForSuccessfulLogin();
      
      
      page =  mailPage.composeClick();
       
   }
      
     public void  sendTextMessagests(){
       
       page.sendMessage("test.auto.lab@gmail.com", "subject", "some text")
              .waitForSuccessfullSending()
              .reload();
       Assert.assertEquals(mailPage.getMessageAddressee(), "me");
       mailPage.logout();
     }

}
