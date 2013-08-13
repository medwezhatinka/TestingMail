/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.driver;

import com.google.common.base.Function;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static boolean parallel = false;
    private static DesiredCapabilities capability;
    public static final Logger log = Logger.getLogger(Driver.class);
    public static ResourceBundle resource = ResourceBundle.getBundle("settings");
    public static final String scrollJS = resource.getString("scrollJS");
    public static final int forWait = Integer.valueOf(resource.getString("forWait"));
    public static final int timeout = Integer.valueOf(resource.getString("timeout"));

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setAugmenter() {
        if (parallel) {
            driver.set(new Augmenter().augment(driver.get()));
        }

    }

    public static void setRemoteDriver(String browser, String platform) {
        parallel = true;
        capability = new DesiredCapabilities();
        capability.setBrowserName(browser);
        capability.setPlatform(Platform.valueOf(platform));
        try {
            String path = resource.getString("path");
            driver.set(new RemoteWebDriver(new URL(path), capability));
        } catch (MalformedURLException e) {
            log.error(e);
        }
    }

    public static void setLocalDriver() {
        driver.set(new FirefoxDriver());
    }

    public static void close() {
        driver.get().quit();
    }

    public static void javaScriptClick(String xPath) {
//        String JSstr = "var result = document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);"
//                + "result.singleNodeValue.click(); "
//                + "return;";
          String JSstr = resource.getString("JSstr");
        ((JavascriptExecutor) driver.get()).executeScript(String.format(JSstr, xPath));
    }

    public static WebElement findByXpath(String xpath) {
        return driver.get().findElement(By.xpath(xpath));
    }

    public static WebElement findByCSS(String css) {
        return driver.get().findElement(By.cssSelector(css));
    }

    public static WebElement findByID(String id) {
        return driver.get().findElement(By.id(id));
    }

    public static void wait(final String id) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver.get())
                .withTimeout(forWait, TimeUnit.SECONDS)
                .pollingEvery(timeout, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id(id));
            }
        });
    }

    public static void waitfor(final String xpath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver.get())
                .withTimeout(forWait, TimeUnit.SECONDS)
                .pollingEvery(timeout, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xpath));
            }
        });
    }

    public static void acceptAlert() {
        try {
            Driver.getDriver().switchTo().alert().accept();
        } catch (Exception ex) {
            log.warn("Alert is not present.", ex);
        }
    }

    public static void waitforPresentText(String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(driver.get(), forWait);
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(xpath), text));
    }

    public static void waitforNotVisible(String css) {
        WebDriverWait wait = new WebDriverWait(driver.get(), forWait);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css)));
    }

    public static WebElement findByName(String name) {
        return driver.get().findElement(By.name(name));
    }

    public static WebElement findByTagName(String tagName) {
        return driver.get().findElement(By.tagName(tagName));
    }

    public static void switchTo(WebElement webElement) {
        driver.get().switchTo().frame(webElement);
    }

    public static void switchToDefaultContext() {
        driver.get().switchTo().defaultContent();
    }

    public static void waitForElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver.get(), forWait);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForClickable(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver.get(), forWait);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

    }

    public static boolean elementIsPresent(String xpath) {
        try {
            findByXpath(xpath);
            return true;
        } catch (NoSuchFieldError ex) {
            log.warn(String.format("element by xpath= %s not present", xpath));
            return false;
        }
    }
}
