/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import java.lang.reflect.Field;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 *
 * @author Alina_Shumel
 */
public class ExtendedDecorator extends  DefaultFieldDecorator{

  private IElementFactory elementFactory = new DefaultElementFactory();
    

    public ExtendedDecorator(final SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        
        if (IElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends IElement>) field.getType(), wrappedElement);
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }

   
}
