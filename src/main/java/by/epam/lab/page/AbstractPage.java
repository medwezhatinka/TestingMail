/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.ExtendedDecorator;
import com.google.common.base.Function;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractPage {

    private WebDriver driver;
    public static final Logger log = Logger.getLogger(AbstractPage.class);
    public static final String scrollJS = "arguments[0].scrollIntoView();";
    public static final int forWait = 30;
    public static final int timeout = 5;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new ExtendedDecorator(driver), this);
    }

    public static void javaScriptClick(String xPath, WebDriver driver) {
        String JSstr = "var result = document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);"
                + "result.singleNodeValue.click(); "
                + "return;";
        ((JavascriptExecutor) driver).executeScript(String.format(JSstr, xPath));
    }

    public void open(String url) {
        driver.navigate().to(url);
    }

    public void close() {
        driver.close();
    }

    public String getLocation() {
        return driver.getCurrentUrl();
    }

    public WebElement findByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findByCSS(String css) {
        return driver.findElement(By.cssSelector(css));
    }

    public WebElement findByID(String id) {
        return driver.findElement(By.id(id));
    }

    public void wait(final String id) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(forWait, TimeUnit.SECONDS)
                .pollingEvery(timeout, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id(id));
            }
        });
    }

    public void waitfor(final String xpath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(forWait, TimeUnit.SECONDS)
                .pollingEvery(timeout, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xpath));
            }
        });
    }

    public void reload() {
        driver.navigate().refresh();
    }

    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ex) {
            log.warn("Alert is not present.", ex);
        }
    }

    public void waitforPresentText(String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(driver, forWait);
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(xpath), text));
    }

    public void waitforNotVisible(String css) {
        WebDriverWait wait = new WebDriverWait(driver, forWait);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css)));
    }

    public WebElement findByName(String name) {
        return driver.findElement(By.name(name));
    }

    public WebElement findByTagName(String tagName) {
        return driver.findElement(By.tagName(tagName));
    }

    public void switchTo(WebElement webElement) {
        driver.switchTo().frame(webElement);
    }

    public void switchToDefaultContext() {
        driver.switchTo().defaultContent();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, forWait);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public String getAllertTextAndAccept() {
        waitfor(PageLocator.ALERT_DIALOG);
        WebElement allertDialog = findByXpath(PageLocator.ALERT_DIALOG);
        StringBuilder message = new StringBuilder();
        message.append(allertDialog.findElement(By.cssSelector(PageLocator.ALERTDIALOG_ALERT_TEXT)).getText());
        message.append(allertDialog.findElement(By.cssSelector(PageLocator.ALERTDIALOG_TEXT)).getText());
        findByCSS(PageLocator.ALERTDIALOG_ACCEPT_BUTTON).click();
        acceptAlert();
        return message.toString();
    }

    public void timeout(int seconds) {
        long time = System.currentTimeMillis() + seconds * 1000;
        while (time > System.currentTimeMillis()) {
        }
    }

    public void waitForClickable(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, forWait);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

    }

    public boolean elementIsPresent(String xpath) {
        try {
            findByXpath(xpath);
            return true;
        } catch (NoSuchFieldError ex) {
            log.warn(String.format("element by xpath= %s not present", xpath));
            return false;
        }
    }
}
