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

    @FindBy(xpath = "//div[text()='COMPOSE']")
    @CacheLookup
    private Button composeButton;
    @FindBy(xpath = "//table[@class='F cf zt']")
    private WebElement messageTabe;
    @FindBy(xpath = "//div[@class='ajl aib lKgBkb']/div/div/div/div/div/div/div/div/span/a")
    @CacheLookup
    private Button inbox;
    @FindBy(xpath = "//div[@class='nH aqK']")
    private OptionsPanel options;
    @FindBy(css = "div.n6 span")
    private WebElement more;
    @FindBy(xpath = "//a[@title='Trash']")
    private WebElement trash;
    @FindBy(xpath = "//div/div/div[2]/div/div[3]/div/div/div/div[3]/div/div/div/span[@class='nU n1']/a")
    private WebElement spam;
    @FindBy(xpath = "//div/div/div/div[2]/div/div/div/span/a[@title='All Mail']")
    private WebElement allMail;
    @FindBy(xpath = "//div[@class='nH']/div/div[2]/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/div")
    private WebElement setting;
    @FindBy(xpath = "//div[@id='ms']/div")
    private WebElement setting_setting;
    @FindBy(xpath = "//table[@class='F cf zt']")
    private Table messages;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage composeClick() {
        composeButton.click();
        waitfor("//table[@class='cf Ht']/tbody/tr/td/div");
        return new SendMessagePage(getDriver());

    }

    public WebElement getMessageAddressee() {
        return messageTabe.findElement(By.xpath("//tr/td[5]/div/span"));


    }

    public String getText(WebElement webElement) {
        webElement.getText();
        return null;

    }

    public MailPage logout() {
        wait("gbg4");
        WebElement menu = findByID("gbg4");
        menu.click();
        WebElement logout = findByID("gb_71");
        logout.click();
        acceptAllert();
        wait("gaia_loginform");
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
        messageTabe.findElement(By.xpath("//tr/td[2]/div/div")).click();
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
        message.setAddressee(messageTabe.findElement(By.xpath("//tr/td[5]/div/span")).getText());
        message.setSubject(messageTabe.findElement(By.xpath("//tr/td[6]/div//div/div/span")).getText());
        message.setText(messageTabe.findElement(By.xpath("//tr/td[6]/div//div/div/span[2]")).getText());
        message.setTime(messageTabe.findElement(By.xpath("//tr/td[8]/span")).getText());

        return message;

    }

    public TrashPage goToTrashPage() {
        more.click();
        waitForElement(trash);
        trash.click();
        waitfor("//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]");
        return new TrashPage(getDriver());

    }

    public SpamPage goToSpamPage() {
        more.click();
        waitForElement(spam);
        spam.click();
        waitfor("//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]");
        return new SpamPage(getDriver());

    }

    public AllMailPage goToAllMailPage() {
        more.click();
        waitForElement(allMail);
        allMail.click();
        waitfor("//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]");

        return new AllMailPage(getDriver());

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
            if (list.get(4).findElement(By.xpath(".//span")).getCssValue("font-weight").equals("700")
                    && list.get(1).findElement(By.xpath(".//div")).getAttribute("aria-checked").equals("true")) {
                return false;
            }
        }

        return true;
    }

    public boolean checkUnreadMessageSelected() {
        List<List<WebElement>> messageList = messages.getRows();
        for (List<WebElement> list : messageList) {
            if (list.get(4).findElement(By.xpath(".//span")).getCssValue("font-weight").equals("400")
                    && list.get(1).findElement(By.xpath(".//div")).getAttribute("aria-checked").equals("true")) {
                return false;
            }
        }

        return true;
    }

    public void selectRead() {

        options.moveToSelect(getDriver());
        options.selectMessages("Read", getDriver());
    }

    public void selectUnread() {
        options.moveToSelect(getDriver());
        options.selectMessages("Unread", getDriver());
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
            if (!addressee.equals(messages.getCellAt(0, 4).findElement(By.xpath(".//span")).getText())) {
            } else {
                break;
            }
        }
    }
}
