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
public class MailTable extends AbstractContainer {

    @FindBy(xpath = Locator.MAILTABLE_ADDR)
    public WebElement addressee;
    @FindBy(xpath = Locator.MAILTABLE_SUBJECT)
    public WebElement subject;
    @FindBy(xpath = Locator.MAILTABLE_TEXT)
    public WebElement text;
    @FindBy(xpath = Locator.MAILTABLE_TIME)
    public WebElement time;

    public MailTable(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
