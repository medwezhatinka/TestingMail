/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class MailPage extends AbstractPage {

    @FindBy(xpath = "//div[text()='COMPOSE']")
    @CacheLookup
    private Button composeButton;
    @FindBy(xpath = "//table[@class='F cf zt']")
    private WebElement messageTabe;
    @FindBy(xpath = "//div[@class='ajl aib lKgBkb']/div/div/div/div/div/div/div/div/span/a")
    @CacheLookup
    private Button inbox;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage composeClick() {

        composeButton.click();
        waitfor("//table[@class='cf Ht']/tbody/tr/td/div");
        return new SendMessagePage(getDriver());

    }

    public WebElement getMessageAddressee() {
        return messageTabe.findElement(By.xpath("//tr/td[5]/div/span"));//.getAttribute("name");


    }
    
    public String getText(WebElement webElement){
       webElement.getText();
        return null;
        
    }

    public MailPage logout() {


        wait("gbg4");
        WebElement menu = findByID("gbg4");
        menu.click();
        WebElement logout = findByID("gb_71");
        logout.click();
        acceptAllert();
        wait("gaia_loginform");
        return this;


    }
    
    
    public MailPage openMessage(){
      getMessageAddressee().click();
        return this;
    }
    
    public MailPage inboxClick(){
        inbox.click();
        return this;
    }
    
   public MailPage selectMessage(){
       
       messageTabe.findElement(By.xpath("//tr/td[2]/div/div")).click();
       return this;
    }
}
