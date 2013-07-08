/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.MailTable;
import by.epam.lab.element.message.Message;
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
    
    
   public Message getMessage(){
       Message message = new Message();
       message.setAddressee(messageTabe.addressee.getText());
       message.setSubject(messageTabe.subject.getText());
       message.setText(messageTabe.text.getText());
       message.setTime(messageTabe.time.getText());
       
       return message;
       
   } 
    
}
