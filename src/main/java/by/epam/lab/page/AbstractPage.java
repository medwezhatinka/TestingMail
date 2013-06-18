/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.ExtendedDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractPage {
   private WebDriver driver;
   
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new ExtendedDecorator(driver), this);
    }
    
     
    public void open(String url){
         driver.navigate().to(url);
    }
    
    public  void close(){
        driver.close();
    }
     
    public String getLocation(){
        return driver.getCurrentUrl();
    }
   public WebElement findByXpath(String xpath){
       return  driver.findElement(By.xpath(xpath));
   }
   
   public WebElement findByCSS(String css){
       return  driver.findElement(By.cssSelector(css));
   }
   
   public WebElement findByID(String id){
       return  driver.findElement(By.id(id));
   }
   
   public void wait(String id){
          WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
   }
   
    public void waitfor(String xpath){
          WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
   }
}
