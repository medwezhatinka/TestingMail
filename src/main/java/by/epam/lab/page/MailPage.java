/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    
    
    public MailPage Logout(){
       wait("gbg4");
        WebElement menu = findByID("gbg4");
        menu.click();
        WebElement logout = findByID("gb_71");
        logout.click();
        wait("gaia_loginform");
        return this;
        
    }
    
   
}
