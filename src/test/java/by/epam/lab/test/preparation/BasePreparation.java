/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.preparation;

import by.epam.lab.driver.Driver;
import by.epam.lab.test.datareader.TestData;
import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import by.epam.lab.test.Group;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

    protected LoginPage loginPage;
    protected MailPage mailPage;
    public static final Logger log = Logger.getLogger(BasePreparation.class);

    @BeforeSuite(alwaysRun = true)
    public static void tearUpSuite() throws FileNotFoundException, IOException {
        String nameFile = ResourceBundle.getBundle("propertie/settings.properties").getString("log_properties");
        PropertyConfigurator.configure(nameFile);
        TestData.initialize();
    }

    @BeforeTest(alwaysRun = true)
    public static synchronized void tearUpTest(ITestContext context) {
        if (!context.getSuite().getParallel().equals("false")) {
            String browser = context.getCurrentXmlTest().getParameter("browser");
            String platform = context.getCurrentXmlTest().getParameter("platform");
            Driver.setRemoteDriver(browser, platform);
        } else {
            Driver.setLocalDriver();
        }
        log.info("BEFORE TEST RUN!");
    }

    @AfterTest(alwaysRun = true)
    public static void tearDownTest() {
       Driver.close();
        log.info("AFTER TEST RUN!");
    }
}
