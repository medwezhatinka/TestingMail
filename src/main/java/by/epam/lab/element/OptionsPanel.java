/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import by.epam.lab.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class OptionsPanel extends AbstractContainer {

    @FindBy(xpath = Locator.OPTIONSPANEL_ARCHIVE)
    private Button archive;
    @FindBy(xpath = Locator.OPTIONSPANEL_REPORT_SPAM)
    private Button report_spam;
    @FindBy(xpath = Locator.OPTIONSPANEL_DELETE)
    private Button delete;
    @FindBy(xpath = Locator.OPTIONSPANEL_LABELS)
    private WebElement labels;
    @FindBy(xpath = Locator.OPTIONSPANEL_MOVE_TO)
    private WebElement move;
    @FindBy(xpath = Locator.OPTIONSPANEL_SELECT)
    private WebElement select;

    private static final String template = ".//div[text()='%s']";
    
    public OptionsPanel(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void moveToSelect() {
        new Actions(Driver.getDriver()).moveToElement(select).perform();
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

    public void selectMessages(String status) {
        new Actions(Driver.getDriver()).moveToElement(select).click().perform();
        String xpath = String.format(template, status);
        Driver.findByXpath(xpath).click();

    }
}
