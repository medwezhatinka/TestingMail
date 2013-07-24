/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

/**
 *
 * @author Alina_Shumel
 */
import org.openqa.selenium.WebElement;

public interface IContainerFactory {

    <C extends IContainer> C create(Class<C> containerClass, WebElement wrappedElement);
}
