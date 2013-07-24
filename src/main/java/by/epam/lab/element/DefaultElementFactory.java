/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Alina_Shumel
 */
public class DefaultElementFactory implements IElementFactory {

    public <E extends IElement> E create(Class<E> elementClass, WebElement wrappedElement) {
        try {
            return elementClass
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);

        } catch (NoSuchMethodException ex) {
            Logger.getLogger(DefaultElementFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(DefaultElementFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DefaultElementFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DefaultElementFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DefaultElementFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DefaultElementFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
