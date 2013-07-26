/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Alina_Shumel
 */
public interface IAbstractPage {

    public void open(String url);

    public void close();

    public String getLocation();

    public WebElement findByXpath(String xpath);

    public WebElement findByCSS(String css);

    public WebElement findByID(String id);

    public WebElement findByName(String name);

    public WebElement findByTagName(String tagName);

    public void wait(String id);

    public void waitfor(String xpath);

    public void waitforPresentText(String css, String text);

    public void waitForClickable(String xpath);

    public boolean elementIsPresent(String xpath);

    public void switchTo(WebElement webElement);

    public void switchToDefaultContext();

    public void reload();

    public void acceptAllert();

    public String getAllertTextAndAccept();

    public WebDriver getDriver();

    public void waitForElement(WebElement webElement);
}
