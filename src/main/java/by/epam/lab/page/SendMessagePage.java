/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.LargeFileAllertDialog;
import by.epam.lab.element.MessageSendTable;
import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class SendMessagePage extends AbstractPage {

    private static final Logger log = Logger.getLogger(SendMessagePage.class);
    @FindBy(css = "div.aaZ")
    private MessageSendTable newMessage;
    @FindBy(css = "div.Kj-JD")
    private LargeFileAllertDialog dialog;

    public SendMessagePage(WebDriver driver) {
        super(driver);
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
        waitforPresentText(".//div[@class='vh']", "Your message has been sent.");
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

    private SendMessagePage attachFile(String scriptPath, File attachedFile)
            throws IOException, InterruptedException {

        File autoIt = new File(scriptPath);
        Process p = Runtime.getRuntime().exec(
                autoIt.getAbsolutePath() + " " + "\"" + attachedFile.getAbsolutePath() + "\"");
        p.waitFor();
        return this;
    }

    public SendMessagePage waitforsuccessfulAttach(File attachedFile) {
        String xpath = String.format("//div[text()='%s']/following-sibling::div[text()='%s']",
                attachedFile.getName(), Util.getFormatSize(attachedFile));
        waitfor(xpath);
        return this;
    }

    public SendMessagePage createMessageWithAttachedFile(String toEmail, String subject,
            String body, String script, File attachFile) {
        newMessage.fillTo(toEmail).fillSubject(subject);
        switchTo(newMessage.getIframe());
        findByTagName("body").sendKeys(body);
        switchToDefaultContext();
        newMessage.attachFileClick();
        try {
            attachFile(script, attachFile);
        } catch (IOException ex) {
            log.error(ex);
        } catch (InterruptedException ex) {
            log.error(ex);
        }


        return this;
    }

    public SendMessagePage send() {
        newMessage.send();
        return this;
    }

    public String getAllertTextandClose() {
        String message = dialog.getMessage();
        dialog.cancelClick();
        return message;
    }
}
