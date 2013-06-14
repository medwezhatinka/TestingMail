package com.mycompany.testimgmail;

import by.epam.lab.element.ExtendedDecorator;
import by.epam.lab.page.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        System.out.println( "Hello World!" );
       FirefoxDriver firefox = new FirefoxDriver();
        firefox.navigate().to("http://www.gmail.com");
       // firefox.navigate().to("http://www.google.com");
        System.out.println("Запустил");
        LoginPage loginPage = new LoginPage(firefox);
        //System.out.println(loginPage.getName());
        loginPage.Login("medwezhatinka@gmail.com", "559283medwedik");
    }
}
