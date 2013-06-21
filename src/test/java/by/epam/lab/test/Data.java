/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
public class Data {
    
    @DataProvider(name = "data")
	    public Object[][] getData(Method m) throws IOException, InvalidFormatException {
         Workbook workbook = WorkbookFactory.create(new FileInputStream("testdata.xlsx")); 
       Sheet sheet = workbook.getSheet(m.getAnnotation(Test.class).groups()[0]);
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            if (m.getClass().getSimpleName().equals(sheet.getRow(i).getCell(0))) {
               
                sheet.getRow(i).getLastCellNum();
            }
        }
   
        return null;
    }
    }
   
