/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import java.lang.reflect.Field;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

/**
 *
 * @author Alina_Shumel
 */
public class ExtendedDecorator extends DefaultFieldDecorator {

    private IElementFactory elementFactory = new DefaultElementFactory();
    private IContainerFactory containerFactory = new DefaultContainerFactory();

    public ExtendedDecorator(final SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        if (IContainer.class.isAssignableFrom(field.getType())) {
            return decorateContainer(loader, field);
        }
        if (IElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends IElement>) field.getType(), wrappedElement);
    }

    private Object decorateContainer(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        final IContainer container = containerFactory.create((Class<? extends IContainer>) field.getType(), wrappedElement);

        PageFactory.initElements(new ExtendedDecorator(wrappedElement), container);
        return container;
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }
}
