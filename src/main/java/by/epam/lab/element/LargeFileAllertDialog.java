/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class LargeFileAllertDialog extends AbstractContainer {

    @FindBy(css = Locator.LARGEFILEALERT_MESSAGE)
    private TextInput message;
    @FindBy(css = Locator.LARGEFILEALERT_CANCEL)
    private Button cancel;

    public LargeFileAllertDialog(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public String getMessage() {
        String message1 = message.getText();
        return message1;
    }

    public void cancelClick() {
        cancel.click();
    }
}
