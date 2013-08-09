/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.listener;

import by.epam.lab.test.preparation.BasePreparation;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 *
 * @author Alina_Shumel
 */
public class TestListener extends TestListenerAdapter {

    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TestListener.class);

    @Override
    public void onTestSuccess(ITestResult tr) {
        log.info("Test: '" + tr.getMethod().getTestClass().getName() + "' - PASSED");
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        log.info("Test: '" + testResult.getMethod().getTestClass().getName() + "' - FAILED");
        try {
            BasePreparation.setAugmenter();
            Calendar currentDate = Calendar.getInstance();
            String workDir = System.getProperty("user.dir") + "\\screenshos\\";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMMdd_HH_mm_ss");
            String dateNow = dateFormat.format(currentDate.getTime());
            WebDriver driver = BasePreparation.getDriver();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(workDir + dateNow + ".jpg"));
            Reporter.log("<img src=\"file:///" + workDir + dateNow + ".JPG\" alt=\"\"/><br />");
        } catch (IOException ex) {
            log.error(ex);
        }
    }
}