/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic;

import by.epam.lab.page.MailPage;
import by.epam.lab.page.SendMessagePage;

/**
 *
 * @author Alina_Shumel
 */
public class SendMessage {
    public static void sendCorrectMessage(MailPage mailPage, String addressee, String subject, String text){
        SendMessagePage page = mailPage.composeClick();
        page.sendMessage(addressee, subject, text)
                .waitForSuccessfullSending()
                .reload();
    }
    
}
