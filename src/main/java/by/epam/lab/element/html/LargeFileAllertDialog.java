/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element.html;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author Alina_Shumel
 */
@Block(
        @FindBy(css = "div.Kj-JD"))
public class LargeFileAllertDialog extends HtmlElement {

    @FindBy(css = "span.Kj-JD-K7-K0")
    private TextBlock message;
    @FindBy(css = "span.Kj-JD-K7-Jq")
    private WebElement cancel;

    public String getMessage() {
        String message1 = message.getText();
        System.out.println(message1);
        return message1;
    }

    public void cancelClick() {
        cancel.click();
    }
}
