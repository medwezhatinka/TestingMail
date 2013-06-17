/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class LoginForm extends  AbstractContainer{

    @FindBy(id="Email")
    WebElement  Email;
    @FindBy(id="Passwd")
    WebElement Passwd;
    
    WebElement signIn;
    
   
    
    public LoginForm(WebElement wrappedElement) {
        super(wrappedElement);
      //  Email =  wrappedElement.findElement(By.id("Email"));
      //  Passwd = wrappedElement.findElement(By.id("Passwd"));
      //  signIn = wrappedElement.findElement(By.id("signIn"));
        
       
    }
    
    public LoginForm fillEmail(String username){
       Email.sendKeys(username);
       return this;
    }
    
    public LoginForm fillPassword(String password){
       Passwd.sendKeys(password);
       return this;
    }
    
    public void submit(){
       signIn.click();
       
    }
    
    
}
