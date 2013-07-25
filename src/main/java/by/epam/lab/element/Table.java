/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Alina_Shumel
 */
public class Table extends AbstractElement {

    private static final String rowXpath = ".//tr";
    private static final String columnXpath = ".//td";

    public Table(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public List<WebElement> getRowsElement() {
        return getWrappedElement().findElements(By.xpath(rowXpath));
    }

    public List<List<WebElement>> getRows() {
        List<List<WebElement>> rows = new ArrayList<List<WebElement>>();
        List<WebElement> rowElements = getWrappedElement().findElements(By.xpath(rowXpath));
        for (WebElement rowElement : rowElements) {
            rows.add(rowElement.findElements(By.xpath(columnXpath)));
        }
        return rows;
    }

    public List<List<WebElement>> getColumns() {
        List<List<WebElement>> columns = new ArrayList<List<WebElement>>();
        List<List<WebElement>> rows = getRows();
        if (rows.isEmpty()) {
            return columns;
        }
        int columnsNumber = rows.get(0).size();
        for (int i = 0; i < columnsNumber; i++) {
            List<WebElement> column = new ArrayList<WebElement>();
            for (List<WebElement> row : rows) {
                column.add(row.get(i));
            }
            columns.add(column);
        }
        return columns;
    }

    public WebElement getCellAt(int i, int j) {
        return getRows().get(i).get(j);
    }
}
