/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.ExtendedDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alina_Shumel
 */
public class AbstractPage implements IAbstractPage{
   private WebDriver driver;
   
    final static String JSstr = "var result = document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);" +  
    "result.singleNodeValue.click(); "+
    "return;"; 
   
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new ExtendedDecorator(driver), this);
    }
    
     
    
    
    

 
 public static void javaScriptClick(String xPath, WebDriver driver){
        ((JavascriptExecutor) driver).executeScript(String.format(JSstr, xPath));
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
    
    public  void waitforPresentText(String xpath,String text){
       WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(xpath), text)); 
    }
    
     public  void waitforNotVisible(String css){
       WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css))); 
    }

    public WebElement findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public WebElement findByTagName(String tagName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void pause(long timeout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void waitForClickable(String xpath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean elementIsPresent(String xpath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      public void switchTo(WebElement webElement){
        
         driver.switchTo().frame(webElement);
    }
     
      public void switchToDefaultContext(){
        
        driver.switchTo().defaultContent();
    }
     

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForElement(WebElement webElement) {
      WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(webElement)); 
    }

    public String getAllertTextAndAccept() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         
     
     

}
