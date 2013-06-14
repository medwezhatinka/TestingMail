/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;

/**
 *
 * @author Alina_Shumel
 */
public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

   
@FindBy(id = "signIn")
 private Form f;
    
   /* @FindBy(id = "gaia_loginform")
    WebElement form;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String username, String password) {

        WebElement email = form.findElement(By.id("Email"));
        WebElement passwd = form.findElement(By.id("Passwd"));
        email.sendKeys(username);
        passwd.sendKeys(password);
        form.submit();

    }
   */ 
    public void Login(String username, String password) {

           f.click();

    } 
    
}
