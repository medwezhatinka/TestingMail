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

    @FindBy(xpath = "..//td[5]/div[1]/span[1]")
    public WebElement addressee;
    @FindBy(xpath = "..//td[6]/div/div/div/span")
    public WebElement subject;
    @FindBy(xpath = "..//td[6]/div/div/div/span[2]")
    public WebElement text;
    @FindBy(xpath = "..//td[8]/span")
    public WebElement time;

    public MailTable(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
