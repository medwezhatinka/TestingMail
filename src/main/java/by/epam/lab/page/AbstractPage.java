/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.driver.Driver;
import by.epam.lab.element.ExtendedDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractPage {

    public static final Logger log = Logger.getLogger(AbstractPage.class);

    public AbstractPage() {
        PageFactory.initElements(new ExtendedDecorator(Driver.getDriver()), this);
    }

    public void open(String url) {
        Driver.getDriver().navigate().to(url);
    }

    public String getLocation() {
        return Driver.getDriver().getCurrentUrl();
    }

    public void reload() {
        Driver.getDriver().navigate().refresh();
    }

    public String getAllertTextAndAccept() {
        Driver.waitfor(PageLocator.ALERT_DIALOG);
        WebElement allertDialog = Driver.findByXpath(PageLocator.ALERT_DIALOG);
        StringBuilder message = new StringBuilder();
        message.append(allertDialog.findElement(By.cssSelector(PageLocator.ALERTDIALOG_ALERT_TEXT)).getText());
        message.append(allertDialog.findElement(By.cssSelector(PageLocator.ALERTDIALOG_TEXT)).getText());
        Driver.findByCSS(PageLocator.ALERTDIALOG_ACCEPT_BUTTON).click();
        Driver.acceptAlert();
        return message.toString();
    }

    public void timeout(int seconds) {
        long time = System.currentTimeMillis() + seconds * 1000;
        while (time > System.currentTimeMillis()) {
        }
    }
}
