package com.mycompany.testimgmail;

import by.epam.lab.element.ExtendedDecorator;
import by.epam.lab.page.LoginPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Workbook workbook = WorkbookFactory.create(new FileInputStream("testdata.xlsx")); 
          Sheet sheet = workbook.getSheet("global");
           for (int i = 0; i < sheet.getLastRowNum(); i++) {
               if ("Username".equals(sheet.getRow(i).getCell(0).toString())) {
                  
                   sheet.getRow(i).getLastCellNum();
               }
           }
           
   //        System.out.println( "Hello World!" );
   //       FirefoxDriver firefox = new FirefoxDriver();
   //        firefox.navigate().to("http://www.gmail.com");
   //       // firefox.navigate().to("http://www.google.com");
   //        System.out.println("Запустил");
   //        LoginPage loginPage = new LoginPage(firefox);
   //        //System.out.println(loginPage.getName());
   //        loginPage.Login("medwezhatinka@gmail.com", "559283medwedik");
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
