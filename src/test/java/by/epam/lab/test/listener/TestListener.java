/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.listener;

import by.epam.lab.test.FirefoxTests;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.log4j.Priority;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 *
 * @author Alina_Shumel
 */
public class TestListener extends TestListenerAdapter{
   
 public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TestListener.class);
    
 
 
 
 
 
    @Override
    public void onTestSuccess(ITestResult tr) {
       
        log.log(Priority.INFO, "Test: '"+tr.getMethod().getMethodName()+"' - PASSED");
    }
    
    
    @Override
    public  void onTestFailure(ITestResult testResult){
       
        log.error(testResult.getMethod().getMethodName());
       
        try {
       
            Robot _robot = new Robot();
            Calendar currentDate = Calendar.getInstance();
            String workDir = System.getProperty("user.dir")+"\\screenshos\\";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMMdd_HH_mm_ss");
            String dateNow = dateFormat.format(currentDate.getTime());
            BufferedImage screenshot = _robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenshot, "JPG", new File(workDir+dateNow+".jpg"));
            Reporter.log("<img src=\"file:///"+workDir+dateNow+".JPG\" alt=\"\"/><br />");
         
        } catch (AWTException ex) {
        //    log.log(Priority.ERROR, ex, ex);
          //  Logger.getLogger(TestListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
         //    log.log(Priority.ERROR, ex, ex);
          //  Logger.getLogger(TestListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}