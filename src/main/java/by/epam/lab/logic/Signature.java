/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic;

import by.epam.lab.driver.Driver;
import by.epam.lab.page.MailPage;
import by.epam.lab.page.Settings;

/**
 *
 * @author Alina_Shumel
 */
public class Signature {

    public static void addSignature(MailPage mailPage, String signature) {
        Settings settings = mailPage.openSettings();
        settings.addSignature(signature)
                .save_changes();
    }

    public static void removeSignature(MailPage mailPage) {
        mailPage.timeout(1);
        mailPage.inboxClick();
        Settings settings = mailPage.openSettings();
        settings.deleteSignature()
                .save_changes();
    }
}
