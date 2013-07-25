/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

/**
 *
 * @author Alina_Shumel
 */
import java.lang.reflect.InvocationTargetException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class DefaultContainerFactory implements IContainerFactory {

    public static final Logger log = Logger.getLogger(DefaultContainerFactory.class);

    @Override
    public <C extends IContainer> C create(final Class<C> containerClass, final WebElement wrappedElement) {
        try {
            return containerClass
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException ex) {
            log.error(ex);
        } catch (IllegalAccessException ex) {
            log.error(ex);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
        } catch (InvocationTargetException ex) {
            log.error(ex);
        } catch (NoSuchMethodException ex) {
            log.error(ex);
        } catch (SecurityException ex) {
            log.error(ex);
        }
        return null;

    }
}