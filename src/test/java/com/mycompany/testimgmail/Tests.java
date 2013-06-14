/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testimgmail;

import by.epam.lab.element.ExtendedDecorator;
import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class Tests extends FirefoxTests{
    
    
    
    public Tests() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void autentificationSuccesfull() {
          
      
       LoginPage loginPage = new LoginPage(firefox);
       loginPage.open("http://www.gmail.com");
       loginPage.Login("test.auto.lab@gmail.com", "testautolab");
     //  MailPage mailPage = new  MailPage(firefox);
     //  Assert.assertTrue(mailPage.getLocation().contains("https://mail.google.com/mail/"), "title : " + mailPage.getLocation());
       
           }   
}