/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.element.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class LoginPage extends AbstractPage {

    @FindBy(id = "gaia_loginform")
    private LoginForm form;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage Login(String username, String password) {
        form.fillEmail(username);
        form.fillPassword(password);
        form.submit();
        return this;
    }

    public MailPage waitForSuccessfulLogin() {
        waitfor("//div[text()='COMPOSE']");
        return new MailPage(getDriver());
    }

    public String getErrorPasswordMessage() {
        WebElement error = findByID("errormsg_0_Passwd");
        return error.getText();
    }

    public String getErrorEmailMessage() {
        WebElement error = findByID("errormsg_0_Email");
        return error.getText();
    }

    public LoginPage inputPassword(String password) {
        form.fillPassword(password);
        return this;
    }

    public void loginClick() {
        form.submit();
    }
}
