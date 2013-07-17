/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractContainer implements IContainer{

    protected WebElement wrappedElement;

    public AbstractContainer(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }
     public WebElement getWrappedElement() {
        return wrappedElement;
    }
    
    public boolean isDisplayed() {
       return wrappedElement.isDisplayed();
    }
    
    
}
