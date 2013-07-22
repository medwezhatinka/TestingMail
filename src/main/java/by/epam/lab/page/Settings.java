/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.AddEmailWindow;
import by.epam.lab.element.Button;
import by.epam.lab.element.Select;
import by.epam.lab.element.Table;
import by.epam.lab.element.TextInput;
import static by.epam.lab.page.AbstractPage.javaScriptClick;
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
    
    @FindBy(xpath = "//h2[text()='Settings']")
    private WebElement title;
    @FindBy(xpath = "//input[@name='sx_sg']")
    private WebElement signature_on;
    @FindBy(xpath = "//div[@aria-label='Signature']/iframe")
    private WebElement signature_iframe;
    @FindBy(tagName = "body")
    private TextInput signature_input;
    // @FindBy(how = How.XPATH, using = "//button[text()='Save Changes']")
    @FindBy(how = How.XPATH, using = ".//button[contains(.,'Save Changes')]")
    private Button save_changes;
    @FindBy(how = How.XPATH, using = "//a[text()='Forwarding and POP/IMAP']")
    private WebElement tab;
    @FindBy(xpath = "//input[@value='Add a forwarding address']")
    private Button add_address;
    @FindBy(xpath = "//body/div[@class='Kj-JD']")
    private AddEmailWindow emailAddWindow;
    @FindBy(xpath = "//div[@class='nH Tv1JD']/div/table/tbody/tr[1]/td[2]/div/div[3]/table/tbody/tr[4]/td[2]/input[@value='Verify']")
    private Button verify;
    @FindBy(xpath = "//div[@class='nH Tv1JD']/div/table/tbody/tr[1]/td[2]/div/div[3]/table/tbody/tr[4]/td[2]/input[1]")
    private TextInput verify_code;
    @FindBy(xpath = "//input[@value='Proceed']")
    private Button proceed;
    @FindBy(xpath = "//div[@class='Kj-JD-Jz']/iframe")
    private WebElement form;
    @FindBy(xpath = "//table[@class='F cf zt']")
    private Table messageTable;
    @FindBy(xpath = "//div/table[2]/tbody/tr/td/input[@name='sx_em']")
    private WebElement forwarding_on;
    
    @FindBy(xpath = "//table[@class='cf']/tbody/tr/td[2]/div/div/table[2]/tbody/tr/td[2]/span/select[1]")
    private Select remove_forwarding;
    
    
    
    
    public Settings(WebDriver driver) {
        super(driver);
    }
    
    public Settings addSignature(String signature) {
        waitForElement(title);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", signature_on);
        signature_on.click();
        switchTo(signature_iframe);
        signature_input.sendKeys(signature);
        timeout(1);
        switchToDefaultContext();
        return this;
    }
    
    public Settings save_changes() {
        
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", save_changes.getWrappedElement());
        
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(.,'Save Changes')]")));
        
        
        save_changes.click();
        waitForElement(messageTable.getWrappedElement());
        return this;
    }
    
    public Settings deleteSignature() {
        waitForElement(title);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", signature_on);
        switchTo(signature_iframe);
        
        timeout(1);
        signature_input.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
        timeout(1);
        signature_input.sendKeys(Keys.chord(Keys.DELETE));
        timeout(1);
        switchToDefaultContext();
        
        signature_on.click();
        return this;
        
    }
    
    public void openForwardingTab() {
        waitForElement(title);
        tab.click();
        
        
    }
    
    public Settings clickProceed(WebDriver driver) {
        waitForElement(form);
        driver.switchTo().frame(form);
        proceed.click();
        driver.switchTo().defaultContent();
        return this;
    }
    
    public void addForwardingAddress(String address) {
        add_address.click();
        
        waitfor("//body/div[@class='Kj-JD']");
        emailAddWindow.inputEmail(address)
                .clickNext();
        
        
        clickProceed(getDriver());
        waitForElement(emailAddWindow.getOk().getWrappedElement());
        emailAddWindow.clickOk();
        waitForElement(verify.getWrappedElement());
        
    }
    
    public void removeForwarding(){
        remove_forwarding.select(3);
       acceptAllert();
    }
    
    public void verifyCode(String code) {
        new Actions(getDriver())
                .moveToElement(verify_code.getWrappedElement())
                .click()
                .sendKeys(Keys.chord(Keys.DELETE))
                .build().
                perform();
        
        verify_code.sendKeys(code);
        System.out.println(verify_code.getWrappedElement().getAttribute("value"));
        verify.click();
        waitForElement(forwarding_on);
    }
    
    public void forwardOn() {
        waitForElement(forwarding_on);
        forwarding_on.click();
        javaScriptClick("//button[text()='Save Changes']", getDriver());
        waitForElement(messageTable.getWrappedElement());
    }
}
