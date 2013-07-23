/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.datareader.TestData;
import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author Alina_Shumel
 */
public abstract  class FirefoxTests extends TestData implements Group{
  public static final Logger log = Logger.getLogger(FirefoxTests.class);
 protected static String nameFile = "log4j.properties";
  
       
  protected  static  FirefoxDriver driver;
  LoginPage loginPage;
 MailPage mailPage ;
   
   
  @BeforeSuite(alwaysRun = true)
  public  static void tearUpSuite() throws FileNotFoundException, IOException{
      PropertyConfigurator.configure(nameFile);
     
      driver = new FirefoxDriver();
      TestData.initialize();
    
  }
   
  
  
  @AfterSuite(alwaysRun = true)
  public static  void tearDownSuite(){
      driver.quit();
  }
  
  
  
  
}
