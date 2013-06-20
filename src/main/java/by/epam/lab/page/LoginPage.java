/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class LoginPage extends AbstractPage {

    
    @FindBy(id = "gaia_loginform")
    LoginForm form;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MailPage Login(String username, String password) {

        form.fillEmail(username);
        form.fillPassword(password);
        form.submit();
        waitfor("//div[text()='COMPOSE']");
        return new MailPage(getDriver());
        

    }
    
  public String getErrorPasswordMessage(){
       WebElement error = findByID("errormsg_0_Passwd");
       return error.getText();
      
           
  }
}
