/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Alina_Shumel
 */
public class LoginPage extends AbstractPage{

    @FindBy(id="gaia_loginform")
    LoginForm gaia_loginform;
   // WebElement form;
    
    public LoginPage(WebDriver driver) {
        super(driver);
       gaia_loginform = new LoginForm(driver.findElement(By.id("gaia_loginform")));
       // PageFactory.initElements(driver, this);
    }

    public LoginForm getGaia_loginform() {
        return gaia_loginform;
    }
    
    
    
    
    
}
