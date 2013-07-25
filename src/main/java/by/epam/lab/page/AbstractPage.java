/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.ExtendedDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractPage implements IAbstractPage {

    private WebDriver driver;
    final static String JSstr = "var result = document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);"
            + "result.singleNodeValue.click(); "
            + "return;";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new ExtendedDecorator(driver), this);
    }

    public static void javaScriptClick(String xPath, WebDriver driver) {
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

    public void wait(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public void waitfor(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void reload() {
        driver.navigate().refresh();
    }

    public void acceptAllert() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ex) {
        }

    }

    public void waitforPresentText(String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(xpath), text));
    }

    public void waitforNotVisible(String css) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
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
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public String getAllertTextAndAccept() {
        waitfor("//div[@class='Kj-JD']");
        WebElement allertDialog = findByXpath("//div[@class='Kj-JD']");
        StringBuilder message = new StringBuilder();
        message.append(allertDialog.findElement(By.cssSelector("span.Kj-JD-K7-K0")).getText());
        message.append(allertDialog.findElement(By.cssSelector("div.Kj-JD-Jz")).getText());
        findByCSS("html.aAX body.aAU div.Kj-JD div.Kj-JD-Jl button.J-at1-auR").click();
        acceptAllert();
        return message.toString();
    }

    public void timeout(int seconds) {
        long time = System.currentTimeMillis() + seconds * 1000;
        while (time > System.currentTimeMillis()) {
        }
    }

    public void pause(long timeout) {
        long time = System.currentTimeMillis() + timeout;
        while (System.currentTimeMillis() < time) {
        }

    }

    public void waitForClickable(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

    }

    public boolean elementIsPresent(String xpath) {
        try {
            findByXpath(xpath);
            return true;
        } catch (NoSuchFieldError ex) {
            return false;
        }
    }
}
