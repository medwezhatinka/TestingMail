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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public abstract class BasePreparation extends TestData implements Group {

    public static final Logger log = Logger.getLogger(BasePreparation.class);
    protected static String nameFile = "log4j.properties";
    //protected static WebDriver driver;
    static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static boolean  parallel=false;
    LoginPage loginPage;
    MailPage mailPage;
    
    static DesiredCapabilities capability;
    static String path = "http://localhost:4444/wd/hub";

    
    public  static WebDriver getDriver() {
           return driver.get();
    }
    
    @BeforeSuite(alwaysRun = true)
    public static void tearUpSuite() throws FileNotFoundException, IOException {
        PropertyConfigurator.configure(nameFile);
        TestData.initialize();
    }
    
     @BeforeTest(alwaysRun = true)
    public static synchronized void tearUpTest(ITestContext context) throws FileNotFoundException, IOException {
        PropertyConfigurator.configure(nameFile);
           TestData.initialize();
          if (!context.getSuite().getParallel().equals("false")) {
             parallel=true;
              capability = new DesiredCapabilities();
        String browser =  context.getCurrentXmlTest().getParameter("browser");
         String platform = context.getCurrentXmlTest().getParameter("platform");
         capability.setBrowserName(browser);
        capability.setPlatform(Platform.valueOf(platform));
        try {
            driver.set(new RemoteWebDriver(new URL(path),capability));
        } catch (MalformedURLException e) {
            log.error(e);
        }
        } else {
             driver.set(new FirefoxDriver());
        }
      
         log.info("BEFORE TEST RUN!");
         
       
    }

    @AfterTest(alwaysRun = true)
    public static void tearDownTest() {
        driver.get().quit();
            log.info("AFTER TEST RUN!");
    }
    
    public static void setAugmenter(){
        if (parallel) {
            driver.set(new Augmenter().augment(driver.get()));
        }
        
    }
}
