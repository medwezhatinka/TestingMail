/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

import by.epam.lab.driver.Driver;
import by.epam.lab.element.LoginForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Alina_Shumel
 */
public class LoginPage extends AbstractPage {

    @FindBy(id = PageLocator.LOGINFORM)
    private LoginForm form;

    public LoginPage() {
        super();
    }

    public LoginPage Login(String username, String password) {
        form.fillEmail(username);
        form.fillPassword(password);
        form.submit();
        return this;
    }

    public MailPage waitForSuccessfulLogin() {
        Driver.waitfor(PageLocator.COMPOSE_BUTTON);
        return new MailPage();
    }

    public String getErrorPasswordMessage() {
        WebElement error = Driver.findByID(PageLocator.PASSWORD_ERROR);
        return error.getText();
    }

    public String getErrorEmailMessage() {
        WebElement error = Driver.findByID(PageLocator.EMAIL_ERROR);
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
