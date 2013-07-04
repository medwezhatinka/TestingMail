/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.html.LargeFileAllertDialog;
import by.epam.lab.element.html.MessageSendTable;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 *
 * @author Alina_Shumel 
 */
public class SendMessagePage extends AbstractPageHtml {

    private MessageSendTable newMessage;
    private LargeFileAllertDialog dialog;

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
    
    private String getFormatSize(File file){
        
         long sizeinbytes = file.length();
        long size= (long) Math.ceil(sizeinbytes/1024.0);
        StringBuilder size_str = new StringBuilder();
        size_str.append("(");
        String _size = String.valueOf(size);
          System.out.println(sizeinbytes);
        System.out.println(size);
        if (size > 999) {
           size_str.append(_size.substring(0, 1));
           size_str.append(",");
           size_str.append(_size.substring(1, _size.length()));
        }else{
            size_str.append(_size);
        }
        size_str.append("K)");
        return size_str.toString();
        
        
    }

    private SendMessagePage attachFile(String scriptPath,  File attachedFile) throws IOException, InterruptedException {
      
        File autoIt = new File(scriptPath);

        Process p = Runtime.getRuntime().exec(
                autoIt.getAbsolutePath() + " " + "\"" + attachedFile.getAbsolutePath() + "\"");
        // ожидание выполнения запроса
        p.waitFor();
        return this;

     
        

    }
    
    public SendMessagePage waitforsuccessfulAttach(File attachedFile){
        waitfor("//div[text()='" + attachedFile.getName() + "']/following-sibling::div[text()='"+ getFormatSize(attachedFile)+"']");
        System.out.println(attachedFile.length());   
        return this;
    }

    public SendMessagePage createMessageWithAttachedFile(String toEmail, String subject,
            String body, String script, File attachFile)
            throws InterruptedException {
        newMessage.fillTo(toEmail).fillSubject(subject);
        switchTo(newMessage.getIframe());
        findByTagName("body").sendKeys(body);
        switchToDefaultContext();
        newMessage.attachFileClick();
      
        try {
            attachFile(script, attachFile);
        } catch (IOException ex) {
            Logger.getLogger(SendMessagePage.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        return this;
    }
    
    
    public SendMessagePage send(){
         newMessage.send();
         return this;
    }
    
    public String getAllertTextandClose(){
        String message = dialog.getMessage();
        dialog.cancelClick();
        
        return  message;
    }
}
