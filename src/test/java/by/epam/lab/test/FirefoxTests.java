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
    
   protected   FirefoxDriver firefox;

    public FirefoxDriver getFirefox() {
        return firefox;
    }
    
   
   
   
//   @BeforeSuite
//   public  void setUpSuite() throws Exception {
//       firefox = new FirefoxDriver();
//        System.out.println("Какогото ХЕРА Я ЗАПУСТИЛ BEFORE SUITE");
//      
//    }
//   
//   @AfterSuite
//    public  void tearDownSuite() throws Exception {
//        firefox.quit();
//        System.out.println("Какогото ХЕРА Я ЗАПУСТИЛ АФТЕР SUITE");
//        
//    }
   
   
    @BeforeClass
    public  void setUpClass() throws Exception {
     
     
       firefox = new FirefoxDriver();
               
         
    }

    @AfterClass
    public  void tearDownClass() throws Exception {
        firefox.quit();
         
       
    }
}
