package com.mycompany.testimgmail;

import org.openqa.selenium.firefox.FirefoxDriver;

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
        firefox.get("http://www.google.com");
       // firefox.navigate().to("http://www.google.com");
        System.out.println("Запустил");
    }
}
