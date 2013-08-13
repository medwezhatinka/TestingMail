/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic;

import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;

/**
 *
 * @author Alina_Shumel
 */
public class Login {

    public static LoginPage openLoginPage(String url) {
        LoginPage loginPage = new LoginPage();
        loginPage.open(url);
        return loginPage;
    }

    public static MailPage correctLogin(LoginPage loginPage, String email, String password) {
        MailPage mailPage = loginPage.Login(email, password)
                .waitForSuccessfulLogin();
        return mailPage;
    }

    public static MailPage SignIn(String url, String email, String password) {
        return openLoginPage(url).Login(email, password).waitForSuccessfulLogin();
    }
}
