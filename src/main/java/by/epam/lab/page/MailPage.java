/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;

/**
 *
 * @author Alina_Shumel
 */
public class MailPage extends AbstractPage{
    @FindBy(tagName="title")
    WebElement title;

    public MailPage(WebDriver driver) {
        super(driver);
    }
    
    
    
   
}
