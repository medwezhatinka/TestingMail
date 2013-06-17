/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import org.openqa.selenium.WebElement;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractContainer implements IContainer{

    protected WebElement wrappedElement;

    public AbstractContainer(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }
    
    
    public boolean isDisplayed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
