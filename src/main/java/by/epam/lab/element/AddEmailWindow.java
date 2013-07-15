/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class AddEmailWindow extends  AbstractContainer{

    public AddEmailWindow(WebElement wrappedElement) {
        super(wrappedElement);
    }
    
   @FindBy(xpath = "//div[@class='PN']/input") 
    private TextInput email;
   
   @FindBy(name = "next")
   private  Button next;
   
   
   @FindBy(xpath = "//input[@value='Proceed']")
   private Button proceed;
   
   @FindBy(xpath = "//iframe[@class='ds']")
   private WebElement form;
   
    @FindBy(name = "ok")
   private  Button ok;
   
   
   
   public AddEmailWindow inputEmail(String email){
         this.email.sendKeys(email);
         return this;
         
   }
   
   
   public AddEmailWindow clickNext(){
       next.click();
       return this;
   }
    
   public AddEmailWindow clickProceed(WebDriver driver){
      driver.switchTo().frame(form);
       proceed.click();
       driver.switchTo().defaultContent();
       return this;
   }
   
   
   public AddEmailWindow clickOk(){
       ok.click();
       return this;
   }

    public TextInput getEmail() {
        return email;
    }

    public Button getNext() {
        return next;
    }

    public Button getProceed() {
        return proceed;
    }

    public Button getOk() {
        return ok;
    }

   
   
}
