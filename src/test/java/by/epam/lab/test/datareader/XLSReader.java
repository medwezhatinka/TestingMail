/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.datareader;

import by.epam.lab.test.datareader.TestData.Key;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumMap;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Alina_Shumel
 */
public class XLSReader {

    public static final Logger log = Logger.getLogger(XLSReader.class);

    public static void getData(String filename, String sheetName, EnumMap<Key, String> map) {
        try {

            Workbook workbook = WorkbookFactory.create(new FileInputStream(filename));
            Sheet sheet = workbook.getSheet(sheetName);
            String keyCell;
            String valueCell;
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                keyCell = sheet.getRow(i).getCell(0).toString();
                valueCell = sheet.getRow(i).getCell(1).toString();
                map.put(Key.valueOf(keyCell), valueCell);
            }
        } catch (FileNotFoundException ex) {
            log.error(ex);
        } catch (IOException ex) {
            log.error(ex);
        } catch (InvalidFormatException ex) {
            log.error(ex);
        }

    }
}
