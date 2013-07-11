/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.Table;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class Mail extends AbstractPage{

    public Mail(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//table[@class='F cf zt']")
    private Table mail;
    
    
    
    public void getMessage(){
        System.out.println(mail.getCellAt(1, 5).getText());
    }
}
