/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.driver.Driver;
import by.epam.lab.util.Util;
import by.epam.lab.element.LargeFileAllertDialog;
import by.epam.lab.element.MessageSendTable;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class SendMessagePage extends AbstractPage {

    @FindBy(css = PageLocator.NEW_EMAIL)
    private MessageSendTable newMessage;
    @FindBy(css = PageLocator.LARGE_FILE_ALERT)
    private LargeFileAllertDialog dialog;
    private String str_body = "body";

    public SendMessagePage() {
        super();
    }

    public SendMessagePage sendMessage(String toEmail, String subject, String body) {
        newMessage.fillTo(toEmail).fillSubject(subject);
        Driver.switchTo(newMessage.getIframe());
        Driver.findByTagName(str_body).sendKeys(body);
        Driver.switchToDefaultContext();
        newMessage.send();
        return this;
    }

    public MailPage waitForSuccessfullSending() {
        Driver.waitforPresentText(PageLocator.SUCCESSFUL_SEND, PageLocator.SUCCESSFUL_SEND_TEXT);
        return new MailPage();
    }

    public SendMessagePage sendMessageWithoutAdresse(String subject, String body) {
        newMessage.fillSubject(subject);
        Driver.switchTo(newMessage.getIframe());
        Driver.findByTagName(str_body).sendKeys(body);
        Driver.switchToDefaultContext();
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
        String xpath = String.format(PageLocator.SUCCESSFUL_ATTACH,
                attachedFile.getName(), Util.getFormatSize(attachedFile));
        Driver.waitfor(xpath);
        return this;
    }

    public SendMessagePage createMessageWithAttachedFile(String toEmail, String subject,
            String body, String script, File attachFile) {
        newMessage.fillTo(toEmail).fillSubject(subject);
        Driver.switchTo(newMessage.getIframe());
        Driver.findByTagName(str_body).sendKeys(body);
        Driver.switchToDefaultContext();
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
