/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.datareader.XLSReader;
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
        
        return XLSReader.getData(null, null, null);
    }
    }
   
