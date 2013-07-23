/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.datareader.TestData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class LoginWithEmptyCreditations extends LoginPreparation{
     @Test(enabled=true, groups = {AUTENTIFICATION})
     public   void autentificationFailedtst(){
       
    
      loginPage.loginClick();
       Assert.assertEquals(loginPage.getErrorEmailMessage(),ENTER_EMAIL_MESSAGE);
 
     }
}
