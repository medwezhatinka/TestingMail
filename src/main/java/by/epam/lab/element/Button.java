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
public class Button extends AbstractElement{

    public Button(WebElement wrappedElement) {
        super(wrappedElement);
    }
   
    
    
    public void click(){
        wrappedElement.click();
    }
}
