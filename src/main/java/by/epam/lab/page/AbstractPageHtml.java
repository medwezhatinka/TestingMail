/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractPageHtml implements IAbstractPage{
     private WebDriver driver;
   
    public AbstractPageHtml(WebDriver driver) {
        this.driver = driver;
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
    public WebElement findByName(String name){
       return  driver.findElement(By.name(name));
   }
   public WebElement findByTagName(String tagName){
       return  driver.findElement(By.tagName(tagName));
   }
   
   public void wait(String id){
          WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
   }
   
    public void waitfor(String xpath){
          WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
   }
    
     public  void waitforPresentText(String css,String text){
       WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector(css), text)); 
    }
     
     public void pause(long timeout){
         long time = System.currentTimeMillis()+ timeout;
          while (System.currentTimeMillis()< time){
             
          }
          
            }
     
     public void waitForClickable(String xpath){
         WebDriverWait wait = new WebDriverWait(driver,30);
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
         
     }
     public boolean elementIsPresent(String xpath){
         try{
            findByXpath(xpath);
            return true;
         }
        catch(NoSuchFieldError ex){
            return false;
        }
     }
     public void switchTo(WebElement webElement){
        
         driver.switchTo().frame(webElement);
    }
     
      public void switchToDefaultContext(){
        
        driver.switchTo().defaultContent();
    }
      public void reload(){
       driver.navigate().refresh();
    }
      
      public void acceptAllert(){
       try{
        driver.switchTo().alert().accept();
        
       }
       catch(Exception ex){
           
       }
        
    }
       public String getAllertTextAndAccept(){
        waitfor("//div[@class='Kj-JD']");
        WebElement allertDialog = findByXpath("//div[@class='Kj-JD']");
        StringBuilder message = new StringBuilder();
        message.append(allertDialog.findElement(By.cssSelector("span.Kj-JD-K7-K0")).getText());
        message.append(allertDialog.findElement(By.cssSelector("div.Kj-JD-Jz")).getText());
        findByCSS("html.aAX body.aAU div.Kj-JD div.Kj-JD-Jl button.J-at1-auR").click();
       // pause(5000);
        acceptAllert();
       return message.toString();
    }

    public WebDriver getDriver() {
        return driver;
    }
 
    
}
