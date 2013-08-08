/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class MessageSendTable extends AbstractContainer {

    @FindBy(xpath = Locator.sendMessageTo)
    private TextInput toTextBox;
    @FindBy(name = Locator.sendMessageSubject)
    private TextInput subjectTextBox;
    @FindBy(xpath = Locator.sendMessageSendButton)
    private Button sendBtn;
    @FindBy(xpath = Locator.sendMessageIFrame)
    private WebElement iframe;
    @FindBy(xpath = Locator.sendMessageCloseButton)
    private WebElement closeButton;
    @FindBy(xpath = Locator.sendMessageAttachButton)
    private Button attachFile;
    
    private static final String body = "body";

    public MessageSendTable(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public WebElement getIframe() {
        return iframe;
    }

    public MessageSendTable fillTo(String email) {
        toTextBox.sendKeys(email);
        return this;
    }

    public MessageSendTable fillSubject(String subject) {
        subjectTextBox.sendKeys(subject);
        return this;
    }

    public void fillText(String msgBody) {
        WebElement text = iframe.findElement(By.tagName(body));
        text.sendKeys(msgBody);

    }

    public void close() {
        closeButton.click();
    }

    public void send() {
        sendBtn.click();
    }

    public void attachFileClick() {
        attachFile.click();
    }
}
