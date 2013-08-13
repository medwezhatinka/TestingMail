/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.driver.Driver;
import by.epam.lab.element.AddEmailWindow;
import by.epam.lab.element.Button;
import by.epam.lab.element.Select;
import by.epam.lab.element.Table;
import by.epam.lab.element.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class Settings extends AbstractPage {

    @FindBy(xpath = PageLocator.SETTINGS_TITLE)
    private WebElement title;
    @FindBy(xpath = PageLocator.SIGNATURE_ON)
    private WebElement signature_on;
    @FindBy(xpath = PageLocator.SIGNATURE_IFRAME)
    private WebElement signature_iframe;
    @FindBy(tagName = PageLocator.SIGNATURE_INPUT)
    private TextInput signature_input;
    @FindBy(how = How.XPATH, using = PageLocator.SAVE_CHANGES_BUTTON)
    private Button save_changes;
    @FindBy(how = How.XPATH, using = PageLocator.FORWARDING_TAB)
    private WebElement tab;
    @FindBy(xpath = PageLocator.ADD_ADDRESS_BUTTON)
    private Button add_address;
    @FindBy(xpath = PageLocator.ADD_ADDDRESS_WINDOW)
    private AddEmailWindow emailAddWindow;
    @FindBy(xpath = PageLocator.VERIFY_BUTTON)
    private Button verify;
    @FindBy(xpath = PageLocator.VERIFY_CODE_INPUT)
    private TextInput verify_code;
    @FindBy(xpath = PageLocator.PROCEED_BUTTON)
    private Button proceed;
    @FindBy(xpath = PageLocator.FORM_WITH_EMAIL)
    private WebElement form;
    @FindBy(xpath = PageLocator.MESSAGES)
    private Table messageTable;
    @FindBy(xpath = PageLocator.FORWARDING_ON)
    private WebElement forwarding_on;
    @FindBy(xpath = PageLocator.REMOVE_FORWARDING)
    private Select remove_forwarding;

    public Settings() {
        super();
    }

    public Settings addSignature(String signature) {
        Driver.waitForElement(title);
        ((JavascriptExecutor) Driver.getDriver()).executeScript(Driver.scrollJS, signature_on);
        signature_on.click();
        Driver.switchTo(signature_iframe);
        signature_input.sendKeys(signature);
        timeout(1);
        Driver.switchToDefaultContext();
        return this;
    }

    public Settings save_changes() {
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript(Driver.scrollJS, save_changes.getWrappedElement());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PageLocator.SAVE_CHANGES_BUTTON)));
        save_changes.click();
        Driver.waitForElement(messageTable.getWrappedElement());
        return this;
    }

    public Settings deleteSignature() {
        Driver.waitForElement(title);
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript(Driver.scrollJS, signature_on);
        Driver.switchTo(signature_iframe);
        timeout(1);
        signature_input.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
        timeout(1);
        signature_input.sendKeys(Keys.chord(Keys.DELETE));
        timeout(1);
        Driver.switchToDefaultContext();
        signature_on.click();
        return this;

    }

    public void openForwardingTab() {
        Driver.waitForElement(title);
        tab.click();
    }

    public Settings clickProceed() {
        Driver.waitForElement(form);
        Driver.switchTo(form);
        proceed.click();
       Driver.switchToDefaultContext();
        return this;
    }

    public void addForwardingAddress(String address) {
        add_address.click();
        Driver.waitfor(PageLocator.FORWARD_DIALOD);
        emailAddWindow.inputEmail(address)
                .clickNext();
        clickProceed();
        Driver.waitForElement(emailAddWindow.getOk().getWrappedElement());
        emailAddWindow.clickOk();
        Driver.waitForElement(verify.getWrappedElement());
    }

    public void removeForwarding() {
        remove_forwarding.select(3);
        Driver.acceptAlert();
    }

    public void verifyCode(String code) {
        new Actions(Driver.getDriver())
                .moveToElement(verify_code.getWrappedElement())
                .click()
                .sendKeys(Keys.chord(Keys.DELETE))
                .perform();
        verify_code.sendKeys(code);
        verify.click();
        Driver.waitForElement(forwarding_on);
    }

    public void forwardOn() {
        Driver.waitForElement(forwarding_on);
        forwarding_on.click();
        Driver.javaScriptClick(PageLocator.SAVE_CHANGES_BUTTON);
        Driver.waitForElement(messageTable.getWrappedElement());
    }
}
