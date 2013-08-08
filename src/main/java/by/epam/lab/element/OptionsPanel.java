/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class OptionsPanel extends AbstractContainer {

    @FindBy(xpath = Locator.optionsPanelArchive)
    private Button archive;
    @FindBy(xpath = Locator.optionsPanelReportSpam)
    private Button report_spam;
    @FindBy(xpath = Locator.optionsPanelDelete)
    private Button delete;
    @FindBy(xpath = Locator.optionsPanelLabels)
    private WebElement labels;
    @FindBy(xpath = Locator.optionsPanelMoveTo)
    private WebElement move;
    @FindBy(xpath = Locator.optionsPanelSelect)
    private WebElement select;

    private static final String template = ".//div[text()='%s']";
    
    public OptionsPanel(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void moveToSelect(WebDriver driver) {
        new Actions(driver).moveToElement(select).perform();
    }

    @Override
    public boolean isDisplayed() {
        if (archive.isDisplayed()
                && report_spam.isDisplayed()
                && delete.isDisplayed()
                && labels.isDisplayed()
                && move.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickDelete() {
        delete.click();
    }

    public void reportSpam() {
        report_spam.click();
    }

    public void archiveClick() {
        archive.click();
    }

    public void selectMessages(String status, WebDriver driver) {
        new Actions(driver).moveToElement(select).click().perform();
        String xpath = String.format(template, status);
        driver.findElement(By.xpath(xpath)).click();

    }
}
