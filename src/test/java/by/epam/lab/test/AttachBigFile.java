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
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class AttachBigFile extends FirefoxTests{
    
    @Test(enabled = true, groups = {"send text"})//, dependsOnGroups = {AUTENTIFICATION}, description = "not ready")
    public void allertDialogMessageAssertion() throws InterruptedException {
        File attachFile = new File(TestData.LARGE_FILE_PATH);
        loginPage = new LoginPage(firefox);
        loginPage.open(TestData.START_URL);
        mailPage = loginPage
                .Login(TestData.CORRECT_EMAIL_TEST, TestData.CORRECT_PASSWORD_TEST).waitForSuccessfulLogin();

        SendMessagePage page = mailPage
                .composeClick();
        page.createMessageWithAttachedFile(TestData.CORRECT_EMAIL_TEST, TestData.SUBJECT,
                TestData.TEXT, TestData.SCRIPT_PATH, attachFile);
        
            Assert.assertEquals(page.getAllertTextandClose(), TestData.LARGE_FILE_MESSAGE);

        mailPage.logout();

    }
}
