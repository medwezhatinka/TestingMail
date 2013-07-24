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
public class AbstractElement implements IElement {

    protected WebElement wrappedElement;

    public AbstractElement(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    public WebElement getWrappedElement() {
        return wrappedElement;
    }

    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}
