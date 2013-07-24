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
public interface IElementFactory {

    <E extends IElement> E create(Class<E> elementClass, WebElement wrappedElement);
}
