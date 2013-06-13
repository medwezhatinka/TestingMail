/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractPage {
   private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
     
    public void open(String url){
         driver.navigate().to(url);
    }
    
    public  void close(){
        driver.close();
    }
     
   public WebElement findByXpath(String xpath){
       return  driver.findElement(By.xpath(xpath));
   }
   
   public WebElement findByCSS(String css){
       return  driver.findElement(By.cssSelector(css));
   }
   
   
}
