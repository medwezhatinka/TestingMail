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
public class TextInput extends AbstractElement{

    public TextInput(WebElement wrappedElement) {
        super(wrappedElement);
    }
    
    public void clear() {
        getWrappedElement().clear();
    }

    /**
     * Prints specified char sequence into this text input.
     *
     * @param keys Text to print.
     */
    public void sendKeys(CharSequence... keys) {
        getWrappedElement().sendKeys(keys);
    }

       /**
     * Retrieves the text entered into this text input.
     *
     * @return Text entered into the text input.
     */
    public String getText() {
        if ("textarea".equals(getWrappedElement().getTagName())) {
            return getWrappedElement().getText();
        }

        String enteredText = getWrappedElement().getAttribute("value");
        if (enteredText == null) {
            return "";
        }
        return enteredText;
    }
}
