/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class AddSignature extends FirefoxTests{
    
    @Test(enabled = true, groups = {"message"})//, dependsOnGroups = {"autentification"})
    public void signAdd() {
        
         long time1 = System.currentTimeMillis()+5000;
       while(time1> System.currentTimeMillis()){}
       
        mailPage.openSettings();
        
        
       long time = System.currentTimeMillis()+5000;
       while(time> System.currentTimeMillis()){}
    }
    

}
