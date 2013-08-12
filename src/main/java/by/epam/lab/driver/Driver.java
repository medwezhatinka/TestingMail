/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author Alina_Shumel
 */
public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static boolean parallel = false;
    private static DesiredCapabilities capability;
    public static final Logger log = Logger.getLogger(Driver.class);

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setAugmenter() {
        if (parallel) {
            driver.set(new Augmenter().augment(driver.get()));
        }

    }

    public static void setRemoteDriver(String browser, String platform) {
        parallel = true;
        capability = new DesiredCapabilities();
        capability.setBrowserName(browser);
        capability.setPlatform(Platform.valueOf(platform));
        try {
            String path = ResourceBundle.getBundle("propertie/settings.propertie").getString("path");
            driver.set(new RemoteWebDriver(new URL(path), capability));
        } catch (MalformedURLException e) {
            log.error(e);
        }
    }

    public static void setLocalDriver() {
        driver.set(new FirefoxDriver());
    }
    
    
    public static void close(){
      driver.get().quit();   
    }
}
