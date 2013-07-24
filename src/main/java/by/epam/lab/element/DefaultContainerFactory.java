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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;

public class DefaultContainerFactory implements IContainerFactory {

    @Override
    public <C extends IContainer> C create(final Class<C> containerClass, final WebElement wrappedElement) {
        try {
            return containerClass
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException ex) {
            Logger.getLogger(DefaultContainerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DefaultContainerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DefaultContainerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DefaultContainerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(DefaultContainerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(DefaultContainerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}