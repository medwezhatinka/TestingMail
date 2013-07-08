/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class OptionsPanel   extends AbstractContainer{

    @FindBy(xpath = "//div[@aria-label='Archive']")
    private Button archive;
     @FindBy(xpath = "//div[@aria-label='Report spam']")
    private Button report_spam;
     @FindBy(xpath = "//div[@aria-label='Delete']")
    private  Button delete;
     @FindBy(xpath = "//div[@aria-label='Labels']")
    private WebElement labels;
     @FindBy(xpath = "//div[@aria-label='Move to']")
    private  WebElement move;
     
     @FindBy(xpath = "//div[@aria-label='Select']")
    private  WebElement select;
    
    
    
    public OptionsPanel(WebElement wrappedElement) {
        super(wrappedElement);
    }

    
    
    
    public void moveToSelect(WebDriver driver){
        new Actions(driver).moveToElement(select).build().perform();
    }
    
    
    @Override
    public boolean isDisplayed() {
        if (archive.isDisplayed() 
                && report_spam.isDisplayed()
                && delete.isDisplayed()
                && labels.isDisplayed()
                && move.isDisplayed()) {
            return true;
        }
        else{
            return false;
        }
    }

  
    
    
}
