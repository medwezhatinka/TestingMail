/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.datareader.TestData;
import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 *
 * @author Alina_Shumel
 */
public abstract class BasePreparation extends TestData implements Group {

    public static final Logger log = Logger.getLogger(BasePreparation.class);
    protected static String nameFile = "log4j.properties";
    //protected static WebDriver driver;
    static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    LoginPage loginPage;
    MailPage mailPage;
    
    static DesiredCapabilities capability;
    static String path = "http://localhost:4444/wd/hub";

    
    public  static WebDriver getDriver() {
   //     if (driver==null) {
       //     try {
     //           driver.set(new RemoteWebDriver(new URL(path), capability));
     //       } catch (MalformedURLException ex) {
     //           log.error(ex);
     //       }
   //     }
        return driver.get();
    }
    
//    @BeforeSuite(alwaysRun = true)
//    public static void tearUpSuite() throws FileNotFoundException, IOException {
//        PropertyConfigurator.configure(nameFile);
//        driver = new FirefoxDriver();
//        TestData.initialize();
//    }
    
     @BeforeTest(alwaysRun = true)
    public static void tearUpTest(ITestContext context) throws FileNotFoundException, IOException {
        PropertyConfigurator.configure(nameFile);
           TestData.initialize();
          if (!context.getSuite().getParallel().equals("false")) {
              capability = new DesiredCapabilities();
        String browser =  context.getCurrentXmlTest().getParameter("browser");
        String platform = context.getCurrentXmlTest().getParameter("platform");
        capability.setBrowserName(browser);
        capability.setPlatform(Platform.valueOf(platform));
        driver.set(new RemoteWebDriver(new URL(path), capability));
        } else {
             driver.set(new FirefoxDriver());
        }
      
               
    }

    @AfterTest(alwaysRun = true)
    public static void tearDownTest() {
        driver.get().quit();
        
    }
}
