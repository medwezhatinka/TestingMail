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

    @FindBy(xpath = ".//td[@class='yX xY ']/div[@class='yW']/span")
    public WebElement addressee;
    @FindBy(xpath = ".//td[@class='xY ']/.//span[@class='y2']/preceding-sibling::span")
    public WebElement subject;
    @FindBy(xpath = ".//td[@class='xY ']/.//span[@class='y2']")
    public WebElement text;
    @FindBy(xpath = ".//td[@class='xW xY ']/span")
    public WebElement time;

    public MailTable(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
