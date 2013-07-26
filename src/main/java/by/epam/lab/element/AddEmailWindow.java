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
public class AddEmailWindow extends AbstractContainer {

    @FindBy(xpath = "//div[@class='PN']/input")
    private TextInput email;
    @FindBy(name = "next")
    private Button next;
    @FindBy(name = "ok")
    private Button ok;

    public AddEmailWindow(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public AddEmailWindow inputEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public AddEmailWindow clickNext() {
        next.click();
        return this;
    }

    public AddEmailWindow clickOk() {
        ok.click();
        return this;
    }

    public Button getOk() {
        return ok;
    }
}
