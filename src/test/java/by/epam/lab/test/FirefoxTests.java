/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
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
   LoginPage loginPage;
    MailPage mailPage ;
  
  @BeforeSuite(alwaysRun = true)
  public  static void tearUpSuite(){
      firefox = new FirefoxDriver();
      
      
  }
   
  
  
  @AfterSuite(alwaysRun = true)
  public static  void tearDownSuite(){
      firefox.quit();
  }
  
  
  @BeforeClass(groups = "send text")
  public  void tearUpClass(){
       System.out.println("before class for send text group");
       loginPage = new LoginPage(firefox);
       loginPage.open(TestData.HOME_PAGE_URL);
  mailPage = loginPage.Login(TestData.CORRECT_EMAIL_TEST, TestData.CORRECT_PASSWORD_TEST).waitForSuccessfulLogin();
}
  @AfterClass(groups = "send text")
  public void tearDownClass(){
    mailPage.logout();
}
}
