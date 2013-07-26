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

    @FindBy(xpath = "//textarea[@name='to']")
    private TextInput toTextBox;
    @FindBy(name = "subjectbox")
    private TextInput subjectTextBox;
    @FindBy(xpath = "//div[text()='Send']")
    private Button sendBtn;
    @FindBy(xpath = "//div[@class='Am Al editable']/iframe")
    private WebElement iframe;
    @FindBy(xpath = "//table[@class='cf Ht']/tbody/tr/td[2]/img[@alt='Close']")
    private WebElement closeButton;
    @FindBy(xpath = "//table[@class='IZ']/tbody/tr/td[4]/div")
    private Button attachFile;

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
        WebElement text = iframe.findElement(By.tagName("body"));
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
