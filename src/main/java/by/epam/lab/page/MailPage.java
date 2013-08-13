/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.driver.Driver;
import by.epam.lab.element.Button;
import by.epam.lab.element.OptionsPanel;
import by.epam.lab.element.Table;
import by.epam.lab.element.message.Message;
import java.util.List;
import org.openqa.selenium.By;
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

    public MailPage() {
        super();
    }

    public SendMessagePage composeClick() {
        composeButton.click();
        Driver.waitfor(PageLocator.NEW_MESSAGE_WINDOW);
        return new SendMessagePage();
    }

    public WebElement getMessageAddressee() {
        return messageTabe.findElement(By.xpath(PageLocator.ADDRESSEE));
    }

    public String getText(WebElement webElement) {
        webElement.getText();
        return null;
    }

    public MailPage logout() {
        Driver.wait(PageLocator.LOGOUT_BUTTON_PANEL);
        WebElement menu = Driver.findByID(PageLocator.LOGOUT_BUTTON_PANEL);
        menu.click();
        WebElement logout = Driver.findByID(PageLocator.LOGOUT_BUTTON);
        logout.click();
        Driver.acceptAlert();
        Driver.wait(PageLocator.LOGINFORM);
        return this;
    }

    public MailPage openMessage() {
        Driver.waitForElement(getMessageAddressee());
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
        options.moveToSelect();
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
        Driver.waitForElement(trash);
        trash.click();
        Driver.waitfor(PageLocator.MESSAGE_MOVE);
        return new MailTablePage();
    }

    public MailTablePage goToSpamPage() {
        more.click();
        Driver.waitForElement(spam);
        spam.click();
        Driver.waitfor(PageLocator.MESSAGE_MOVE);
        return new MailTablePage();

    }

    public MailTablePage goToAllMailPage() {
        more.click();
        Driver.waitForElement(allMail);
        allMail.click();
        Driver.waitfor(PageLocator.MESSAGE_MOVE);
        return new MailTablePage();

    }

    public MailPage deleteMessage() {
        options.moveToSelect();
        options.clickDelete();
        return this;
    }

    public MailPage reportSpam() {
        options.moveToSelect();
        options.reportSpam();
        return this;
    }

    public MailPage archiveMessage() {
        options.moveToSelect();
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

        options.moveToSelect();
        options.selectMessages(read);
    }

    public void selectUnread() {
        options.moveToSelect();
        options.selectMessages(unread);
    }

    public Settings openSettings() {
        new Actions(Driver.getDriver())
                .moveToElement(setting)
                .click()
                .moveToElement(setting_setting)
                .click()
                .perform();
        return new Settings();
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
