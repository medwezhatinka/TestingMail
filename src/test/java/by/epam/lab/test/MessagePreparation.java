/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Alina_Shumel
 */
public class MessagePreparation extends FirefoxTests{
    
    
    @BeforeClass(groups = "message")
  public  void tearUpClass(){
       System.out.println("before class for send text group");
       loginPage = new LoginPage(firefox);
       loginPage.open(TestData.HOME_PAGE_URL);
  mailPage = loginPage.Login(TestData.CORRECT_EMAIL_TEST, TestData.CORRECT_PASSWORD_TEST).waitForSuccessfulLogin();
}
  @AfterClass(groups = "message")
  public void tearDownClass(){
    mailPage.logout();
}
  
  @BeforeMethod(groups = "message")
  public void tearUpMethod()
  {
      System.out.println("BEFORE METHOD!");
  }
  
  @AfterMethod(groups = "message")
  public void tearDownMethod(){
      
  }
}
