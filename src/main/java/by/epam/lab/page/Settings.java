/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.AddEmailWindow;
import by.epam.lab.element.Button;
import by.epam.lab.element.Table;
import by.epam.lab.element.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class Settings extends AbstractPage{
 @FindBy(xpath = "//h2[text()='Settings']")
       private  WebElement title;
    
      @FindBy(xpath = "//input[@name='sx_sg']")
       private WebElement signature_on;

       @FindBy(xpath = "//div[@aria-label='Signature']/iframe")
       private WebElement signature_iframe;
       
       @FindBy(tagName = "body")
       private  TextInput signature_input;
       
     @FindBy(how=How.XPATH,using="//button[text()='Save Changes']") 
       private Button save_changes;
       
  
     
       @FindBy(how=How.XPATH,using="//a[text()='Forwarding and POP/IMAP']") 
       private WebElement tab;
       
       
       @FindBy(xpath = "//input[@value='Add a forwarding address']")
       private Button add_address;
       
       @FindBy(xpath = "//body/div[@class='Kj-JD']")
       private AddEmailWindow emailAddWindow;
       
       
       @FindBy(xpath = "//div[@class='nH Tv1JD']/div/table/tbody/tr[1]/td[2]/div/div[3]/table/tbody/tr[4]/td[2]/input[@value='Verify']")
       private Button verify;
       
        @FindBy(xpath = "//div[@class='nH Tv1JD']/div/table/tbody/tr[1]/td[2]/div/div[3]/table/tbody/tr[4]/td[2]/input[1]")
       private TextInput verify_code;
       
     @FindBy(xpath = "//table[@class='F cf zt']")
       private Table messageTable;
     
     
     
     
     
    public Settings(WebDriver driver) {
        super(driver);
    }
 
    
      public void addSignature(String signature){
         waitForElement(title);
         ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", signature_on); 
         signature_on.click();
         switchTo(signature_iframe);
         signature_input.sendKeys(signature);
         switchToDefaultContext();
     }
      
      
      public void save_changes(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", save_changes.getWrappedElement()); 
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save Changes']")));
        save_changes.click();
       waitForElement(messageTable.getWrappedElement());
      }
      
      
      
      public void deleteSignature(){
       waitForElement(title);
      ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", signature_on); 
       switchTo(signature_iframe);
      signature_input.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
      signature_input.sendKeys(Keys.chord(Keys.DELETE));
       switchToDefaultContext();
       
       signature_on.click();
      
      }
      
      
      public void openForwardingTab(){
          waitForElement(title);
          tab.click();
          
       
      }
      
      
      public void addForwardingAddress(String address) throws InterruptedException{
          add_address.click();
          Thread.sleep(5000);
        //  waitForElement(emailAddWindow.getWrappedElement());
          emailAddWindow.inputEmail(address)
                  .clickNext();
          
      Thread.sleep(5000);
          emailAddWindow.clickProceed(getDriver());
          waitForElement(emailAddWindow.getOk().getWrappedElement());
          emailAddWindow.clickOk();
          waitForElement(verify.getWrappedElement());
                  
      }
      
      
      public void verifyCode(String code){
          
         verify_code.sendKeys(code);
          System.out.println(verify_code.getWrappedElement().getAttribute("value"));
         verify.click();
      }
}
