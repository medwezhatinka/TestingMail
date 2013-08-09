/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.Button;
import by.epam.lab.element.OptionsPanel;
import by.epam.lab.element.Table;
import by.epam.lab.element.message.Message;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class MailPage extends AbstractPage {

    @FindBy(xpath = PageLocator.COMPOSE_BUTTON)
    @CacheLookup
    private Button composeButton;
    @FindBy(xpath = PageLocator.MESSAGE_TABLE)
    private WebElement messageTabe;
    @FindBy(xpath = PageLocator.INBOX)
    @CacheLookup
    private Button inbox;
    @FindBy(xpath = PageLocator.OPTIONS)
    private OptionsPanel options;
    @FindBy(css = PageLocator.MORE)
    private WebElement more;
    @FindBy(xpath = PageLocator.TRASH)
    private WebElement trash;
    @FindBy(xpath = PageLocator.SPAM)
    private WebElement spam;
    @FindBy(xpath = PageLocator.ALL_MAIL)
    private WebElement allMail;
    @FindBy(xpath = PageLocator.SETTINGS)
    private WebElement setting;
    @FindBy(xpath = PageLocator.SETTINGS_SETTINGS)
    private WebElement setting_setting;
    @FindBy(xpath = PageLocator.MESSAGES)
    private Table messages;
    
    private String bold = "700";
    private String normal = "400";
    private String read = "Read";
    private String unread = "Unread";
    private String str_true = "true";

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage composeClick() {
        composeButton.click();
        waitfor(PageLocator.NEW_MESSAGE_WINDOW);
        return new SendMessagePage(getDriver());
    }

    public WebElement getMessageAddressee() {
        return messageTabe.findElement(By.xpath(PageLocator.ADDRESSEE));
    }

    public String getText(WebElement webElement) {
        webElement.getText();
        return null;
    }

    public MailPage logout() {
        wait(PageLocator.LOGOUT_BUTTON_PANEL);
        WebElement menu = findByID(PageLocator.LOGOUT_BUTTON_PANEL);
        menu.click();
        WebElement logout = findByID(PageLocator.LOGOUT_BUTTON);
        logout.click();
        acceptAlert();
        wait(PageLocator.LOGINFORM);
        return this;
    }

    public MailPage openMessage() {
        waitForElement(getMessageAddressee());
        getMessageAddressee().click();
        return this;
    }

    public MailPage inboxClick() {
        inbox.click();
        return this;
    }

    public MailPage selectMessage() {
        messageTabe.findElement(By.xpath(PageLocator.MESSAGE_CHECKBOX)).click();
        return this;
    }

    public boolean optionsPresent() {
        options.moveToSelect(getDriver());
        if (options.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public Message getMessage() {
        Message message = new Message();
        message.setAddressee(messageTabe.findElement(By.xpath(PageLocator.ADDRESSEE)).getText());
        message.setSubject(messageTabe.findElement(By.xpath(PageLocator.SUBJECT)).getText());
        message.setText(messageTabe.findElement(By.xpath(PageLocator.TEXT)).getText());
        message.setTime(messageTabe.findElement(By.xpath(PageLocator.TIME)).getText());

        return message;

    }

    public MailTablePage goToTrashPage() {
        more.click();
        waitForElement(trash);
        trash.click();
        waitfor(PageLocator.MESSAGE_MOVE);
        return new MailTablePage(getDriver());
    }

    public MailTablePage goToSpamPage() {
        more.click();
        waitForElement(spam);
        spam.click();
        waitfor(PageLocator.MESSAGE_MOVE);
        return new MailTablePage(getDriver());

    }

    public MailTablePage goToAllMailPage() {
        more.click();
        waitForElement(allMail);
        allMail.click();
        waitfor(PageLocator.MESSAGE_MOVE);
        return new MailTablePage(getDriver());

    }

    public MailPage deleteMessage() {
        options.moveToSelect(getDriver());
        options.clickDelete();
        return this;
    }

    public MailPage reportSpam() {
        options.moveToSelect(getDriver());
        options.reportSpam();
        return this;
    }

    public MailPage archiveMessage() {
        options.moveToSelect(getDriver());
        options.archiveClick();
        return this;
    }

    public boolean checkReadMessageSelected() {
        List<List<WebElement>> messageList = messages.getRows();
        for (List<WebElement> list : messageList) {
            if (list.get(4).findElement(By.xpath(PageLocator.SPAN)).getCssValue(PageLocator.FONT_WEIGHT).equals(bold)
                    && list.get(1).findElement(By.xpath(PageLocator.DIV)).getAttribute(PageLocator.ARIA_CHECKED).equals(str_true)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkUnreadMessageSelected() {
        List<List<WebElement>> messageList = messages.getRows();
        for (List<WebElement> list : messageList) {
            if (list.get(4).findElement(By.xpath(PageLocator.SPAN)).getCssValue(PageLocator.FONT_WEIGHT).equals(normal)
                    && list.get(1).findElement(By.xpath(PageLocator.DIV)).getAttribute(PageLocator.ARIA_CHECKED).equals(str_true)) {
                return false;
            }
        }
        return true;
    }

    public void selectRead() {

        options.moveToSelect(getDriver());
        options.selectMessages(read, getDriver());
    }

    public void selectUnread() {
        options.moveToSelect(getDriver());
        options.selectMessages(unread, getDriver());
    }

    public Settings openSettings() {
        new Actions(getDriver())
                .moveToElement(setting)
                .click()
                .moveToElement(setting_setting)
                .click()
                .perform();
        return new Settings(getDriver());
    }

    public void waitForMessageFrom(String addressee, long seconds) {
        long time = System.currentTimeMillis() + seconds * 1000;
        while (time > System.currentTimeMillis()) {
            if (!addressee.equals(messages.getCellAt(0, 4)
                    .findElement(By.xpath(PageLocator.SPAN))
                    .getText())) {
            } else {
                break;
            }
        }
    }
}
