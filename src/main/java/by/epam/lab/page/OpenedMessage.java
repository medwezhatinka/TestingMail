/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class OpenedMessage extends AbstractPage {

    @FindBy(xpath = PageLocator.SHOW_ALL_CONTENT)
    private WebElement showAllContent;
    @FindBy(xpath = PageLocator.SIGNATURE)
    private WebElement signature;
    @FindBy(xpath = PageLocator.MESSAGE_BODY)
    private WebElement messageBody;

    public OpenedMessage(WebDriver driver) {
        super(driver);
    }

    public String getSignatureText() {
        waitForElement(showAllContent);
        showAllContent.click();
        waitForElement(signature);
        return signature.getText();
    }

    public String getMessageText() {
        waitForElement(messageBody);
        return messageBody.getText();
    }
}
