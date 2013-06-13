/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testimgmail;

import java.io.File;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class Tests {
    
    public Tests() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         
         System.out.println( "Hello World!" );
         FirefoxProfile profile = new FirefoxProfile();
         
        FirefoxDriver firefox = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")), profile);
        
        firefox.get("http://www.google.com");
       // firefox.navigate().to("http://www.google.com");
        System.out.println("Запустил");
         Assert.assertTrue(true, null);}

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}