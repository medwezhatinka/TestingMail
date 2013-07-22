/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.SendMessagePage;
import static by.epam.lab.test.FirefoxTests.firefox;
import by.epam.lab.test.datareader.TestData;
import java.io.File;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AttachBigFile extends MessagePreparation{
    
     File attachFile;
    
    @Test(enabled = true, groups = {Group.MESSAGE})//, dependsOnGroups = {AUTENTIFICATION}, description = "not ready")
    public void allertDialogMessageAssertion() throws InterruptedException {
       
 
        SendMessagePage page = mailPage
                .composeClick();
        page.createMessageWithAttachedFile(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT,
                TestData.TEXT, TestData.SCRIPT_PATH, attachFile);
        
         Assert.assertEquals(page.getAllertTextandClose(), TestData.LARGE_FILE_MESSAGE);

     

    }
    @BeforeMethod(groups = Group.MESSAGE)
    @Override
    public void tearUpMethod() {

       attachFile = new File(TestData.LARGE_FILE_PATH);

    }

}
