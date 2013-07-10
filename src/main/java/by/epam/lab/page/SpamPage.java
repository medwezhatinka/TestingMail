/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.MailTable;
import by.epam.lab.element.message.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class SpamPage extends AbstractPage{
    
    @FindBy(xpath = "//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]")
    private MailTable messageTabe;
    public SpamPage(WebDriver driver) {
        super(driver);
    }
    
    
   public Message getMessage(){
       Message message = new Message();
      
      //  message.setAddressee(getDriver().findElement(By.xpath("//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]/td[5]/div[1]/span[1]")).getText());
       
      //  message.setSubject(messageTabe.findElement(By.xpath("//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]/td[6]/div/div/div/span")).getText());
      //  message.setText(messageTabe.findElement(By.xpath("//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]/td[6]/div/div/div/span[2]")).getText());
      //  message.setTime(messageTabe.findElement(By.xpath("//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]/td[8]/span")).getText());

       message.setAddressee(messageTabe.addressee.getText());
       
       System.out.println("addr="+messageTabe.addressee.getText());
       message.setSubject(messageTabe.subject.getText());
       System.out.println("subj="+messageTabe.subject.getText());
       message.setText(messageTabe.text.getText());
       System.out.println("text="+messageTabe.text.getText());
       message.setTime(messageTabe.time.getText());
       System.out.println("time="+messageTabe.time.getText());
       
       return message;
       
   } 
    
}


