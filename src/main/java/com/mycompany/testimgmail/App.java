package com.mycompany.testimgmail;

import by.epam.lab.page.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
        loginPage.getGaia_loginform().fillEmail("medwezhatinka@gmail.com").fillPassword("559283medwedik").submit();
    }
}
