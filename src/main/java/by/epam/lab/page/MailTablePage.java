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
public class MailTablePage extends AbstractPage {

    @FindBy(xpath = PageLocator.MAILTABLE)
    private MailTable messageTabe;

    public MailTablePage(WebDriver driver) {
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
