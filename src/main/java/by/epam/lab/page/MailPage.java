/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class MailPage extends AbstractPage{
    @FindBy(xpath = "//div[text()='COMPOSE']")
    @CacheLookup
    private Button composeButton;
     @FindBy(xpath = "//table[@class='F cf zt']")
     private WebElement messageTabe;

    public MailPage(WebDriver driver) {
        super(driver);
    }
    
    
    public MailPage  composeClick(){
        
        composeButton.click();
        return this;
        
    }
    
    public  String getMessageAddressee(){
        return messageTabe.findElement(By.xpath("//tr/td[5]/div/span")).getAttribute("name");
    }
    public MailPage logout(){
        
       
            wait("gbg4");
        WebElement menu = findByID("gbg4");
        menu.click();
        WebElement logout = findByID("gb_71");
        logout.click();
        acceptAllert();
        wait("gaia_loginform");
        return this; 
       
        
    }
    
   
}
