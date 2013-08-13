/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic;

import by.epam.lab.element.message.Message;
import by.epam.lab.page.LoginPage;
import by.epam.lab.page.MailPage;
import by.epam.lab.page.OpenedMessage;
import by.epam.lab.page.SendMessagePage;
import by.epam.lab.page.Settings;
import by.epam.lab.util.Util;

/**
 *
 * @author Alina_Shumel
 */
public class Forwarding {

    public static void addEmail(MailPage mailPage, String email) {
        Settings settings = mailPage.openSettings();
        settings.openForwardingTab();
        settings.addForwardingAddress(email);
        mailPage.logout();
    }

    public static String getConfirmationCode(LoginPage loginPage, String email,
            String password, String codeName, int length) {
        MailPage mailPage = loginPage.Login(email, password)
                .waitForSuccessfulLogin();
        mailPage.openMessage();
        OpenedMessage openedMessage = new OpenedMessage();
        String code = Util.substringAfter(openedMessage.getMessageText(), codeName, length);
        mailPage.logout();
        return code;
    }

    public static void verifyCode(LoginPage loginPage, String email, String password, String code) {
        MailPage mailPage = loginPage.Login(email, password)
                .waitForSuccessfulLogin();
        Settings settings = mailPage.openSettings();
        settings.openForwardingTab();
        settings.verifyCode(code);
        settings.forwardOn();
        mailPage.logout();
    }

    public static void sendMessage(LoginPage loginPage, String email,
            String password, String addressee, String subject, String text) {
        MailPage mailPage = loginPage.Login(email, password)
                .waitForSuccessfulLogin();
        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(addressee, subject, text)
                .waitForSuccessfullSending()
                .logout();
    }

    public static Message checkMessagePresent(LoginPage loginPage, String email, String password, String name, int seconds) {
        MailPage mailPage = loginPage.Login(email, password)
                .waitForSuccessfulLogin();
        mailPage.waitForMessageFrom(name, seconds);
        Message message = mailPage.getMessage();
        mailPage.logout();
        return message;
    }

    public static void removeForwarding(LoginPage loginPage, String email,
            String password) {
        MailPage mailPage = loginPage.Login(email, password)
                .waitForSuccessfulLogin();
        Settings settings = mailPage.openSettings();
        settings.openForwardingTab();
        settings.removeForwarding();
    }
}
