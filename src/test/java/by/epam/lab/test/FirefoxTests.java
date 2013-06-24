/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
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
    
  protected  static  FirefoxDriver firefox;
  
  
  @BeforeSuite
  public  static void tearUpSuite(){
      firefox = new FirefoxDriver();
      
      
  }
   
  
  
  @AfterSuite
  public static  void tearDownSuite(){
      firefox.quit();
  }
  
  
}
