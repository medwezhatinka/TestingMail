/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import java.lang.reflect.InvocationTargetException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Alina_Shumel
 */
public class DefaultElementFactory implements IElementFactory {

    public static final Logger log = Logger.getLogger(DefaultElementFactory.class);

    public <E extends IElement> E create(Class<E> elementClass, WebElement wrappedElement) {
        try {
            return elementClass
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);

        } catch (NoSuchMethodException ex) {
            log.error(ex);
        } catch (SecurityException ex) {
            log.error(ex);
        } catch (InstantiationException ex) {
            log.error(ex);
        } catch (IllegalAccessException ex) {
            log.error(ex);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
        } catch (InvocationTargetException ex) {
            log.error(ex);
        }
        return null;
    }
}
