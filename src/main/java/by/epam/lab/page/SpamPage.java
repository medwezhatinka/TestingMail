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
public class SpamPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]")
   // @FindBy(xpath = "//table[@class='F cf zt']/tbody/tr")
    private MailTable messageTabe;

    public SpamPage(WebDriver driver) {
        super(driver);
    }

    public Message getMessage() {
        Message message = new Message();
        message.setAddressee(messageTabe.addressee.getText());
        message.setSubject(messageTabe.subject.getText());
        message.setText(messageTabe.text.getText());
        message.setTime(messageTabe.time.getText());
        return message;

    }
}
