/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class OpenedMessage extends AbstractPage{

    public OpenedMessage(WebDriver driver) {
        super(driver);
    }
     @FindBy(xpath = "//div[@aria-label='Show trimmed content']")
    private WebElement showAllContent;
     
     
   @FindBy(xpath = "//span[@class='HOEnZb adL']/font/div/div")
    private WebElement signature;
    @FindBy(xpath = "//div[@class='gs']/div[6]/div")
   private WebElement messageBody;
   
   
   
   public String getSignatureText(){
       waitForElement(showAllContent);
       showAllContent.click();
      waitForElement(signature);
       return signature.getText();
   }
   
   public String getMessageText(){
       waitForElement(messageBody);
       return messageBody.getText();
   }
   
}
