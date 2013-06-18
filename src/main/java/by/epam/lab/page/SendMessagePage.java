/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.html.MessageSendTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 *
 * @author Alina_Shumel
 */
public class SendMessagePage {

    private WebDriver driver;
            
    private MessageSendTable newMessage;

    public SendMessagePage(WebDriver driver) {
        this.driver = driver;
         HtmlElementLoader.populatePageObject(this, driver);
    }
    
    
    public void sendMessage(String toEmail, String subject, String body){
       newMessage.fillTo(toEmail).fillSubject(subject);
       driver.switchTo().frame(newMessage.getIframe());
       driver.findElement(By.tagName("body")).sendKeys(body);
       driver.switchTo().defaultContent();
        newMessage.send();
      // newMessage.fillSubject(subject).fillText(body).send();
    }
}
