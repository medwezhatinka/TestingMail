/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Alina_Shumel
 */
public class Select extends AbstractElement {

    public static  final String option = "option";
    
    public Select(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public List<WebElement> getOptions() {
        return wrappedElement.findElements(By.tagName(option));
    }

    public void select(int position) {
        WebElement element;
        List<WebElement> options = getOptions();
        if (position - 1 < options.size()) {
            element = options.get(position - 1);
            element.click();
        }
    }
}
