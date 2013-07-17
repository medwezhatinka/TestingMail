/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

/**
 *
 * @author Alina_Shumel
 */
public class TestNGAppender extends AppenderSkeleton {

    
    
    @Override
    protected void append(LoggingEvent event) {
        Reporter.log(getLayout().format(event)+"<br/>");
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return true;
    }
}
