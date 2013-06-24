/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.datareader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Alina_Shumel
 */
public class XLSReader {
     public static Object[][] getData(String filename, String sheetName, String className){
       try {
           Object[][] obj =  new Object[1][];
             Workbook workbook = WorkbookFactory.create(new FileInputStream(filename)); 
            Sheet sheet = workbook.getSheet(sheetName);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                if (className.equals(sheet.getRow(i).getCell(0).toString())) {
                   
                    int count = sheet.getRow(i).getLastCellNum();
                    obj[0]= new Object[count-1];
                    for (int j = 1; j < count; j++) {
                       obj[0][j-1]= sheet.getRow(i).getCell(j).toString();
                    }
                }
            }
               
         return obj;
       } catch (FileNotFoundException ex) {
           Logger.getLogger(XLSReader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(XLSReader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InvalidFormatException ex) {
           Logger.getLogger(XLSReader.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
    
}
