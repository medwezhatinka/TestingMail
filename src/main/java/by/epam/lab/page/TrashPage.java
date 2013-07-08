/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.MailTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class TrashPage extends AbstractPage{

    
     @FindBy(xpath = "//table[@class='F cf zt']/tbody/tr")
    private MailTable messageTabe;
    public TrashPage(WebDriver driver) {
        super(driver);
    }
    
    
    
    
}
