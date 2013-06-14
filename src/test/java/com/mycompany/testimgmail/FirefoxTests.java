/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testimgmail;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author Alina_Shumel
 */
public abstract  class FirefoxTests {
    
   protected  static FirefoxDriver firefox ;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
       firefox = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        firefox.quit();
    }
}
