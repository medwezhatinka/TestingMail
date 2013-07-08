/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.Button;
import by.epam.lab.element.OptionsPanel;
import by.epam.lab.element.message.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage composeClick() {

        composeButton.click();
        waitfor("//table[@class='cf Ht']/tbody/tr/td/div");
        return new SendMessagePage(getDriver());

    }

    public WebElement getMessageAddressee() {
        return messageTabe.findElement(By.xpath("//tr/td[5]/div/span"));//.getAttribute("name");


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
}
