/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.html.MessageSendTable;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 *
 * @author Alina_Shumel
 */
public class SendMessagePage extends AbstractPageHtml {

    private MessageSendTable newMessage;

    public SendMessagePage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public SendMessagePage sendMessage(String toEmail, String subject, String body) {
        newMessage.fillTo(toEmail).fillSubject(subject);
        switchTo(newMessage.getIframe());
        findByTagName("body").sendKeys(body);
        switchToDefaultContext();
        newMessage.send();
        return this;


    }

    public MailPage waitForSuccessfullSending() {
        waitforPresentText("div.vh", "Your message has been sent.");
        return new MailPage(getDriver());
    }

    public SendMessagePage sendMessageWithoutAdresse(String subject, String body) {
        newMessage.fillSubject(subject);
        switchTo(newMessage.getIframe());
        findByTagName("body").sendKeys(body);
        switchToDefaultContext();
        newMessage.send();
        return this;

    }

    public void closeAndSave() {
        newMessage.close();
    }
    
    public  void sendMessageWithAttachedFile(String toEmail, String subject, String body,String path) throws InterruptedException{
         newMessage.fillTo(toEmail).fillSubject(subject);
        switchTo(newMessage.getIframe());
        findByTagName("body").sendKeys(body);
        switchToDefaultContext();
        newMessage.attachFileClick();
         File autoIt = new File("src/main/resources/test3.exe");
        try {
             Process p = Runtime.getRuntime().exec(
                autoIt.getAbsolutePath() + " " + path);
        // ожидание выполнения запроса
        p.waitFor();
        } catch (IOException ex) {
            System.out.println("КОСЯК");
        }
        
        waitfor("//div[@aria-label='Attachment: trash.png. Press enter to view the attachment and delete to remove it']");
       // long time2 =System.currentTimeMillis()+ 10000;
      //   while (time2 > System.currentTimeMillis()) {             
             
      //   }
        newMessage.send();
    }
}
