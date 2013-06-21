/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author Alina_Shumel
 */
public abstract  class FirefoxTests {
    
   protected  static FirefoxDriver firefox;

   
    public static FirefoxDriver getFirefox() {
        return firefox;
    }
    
   
   
   
   @BeforeSuite
   public static void setUpSuite() throws Exception {
       firefox = new FirefoxDriver();
          
       
      
    }
   
   @AfterSuite
    public static void tearDownSuite() throws Exception {
        firefox.quit();
        
       
        
    }
   
   
    @BeforeClass
    public static void setUpClass() throws Exception {
     
   
   
               
         
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
        
        
       
    }
}
