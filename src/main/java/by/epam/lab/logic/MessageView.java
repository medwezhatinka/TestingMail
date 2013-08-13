/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic;

import by.epam.lab.page.MailPage;

/**
 *
 * @author Alina_Shumel
 */
public class MessageView {

    public static String getReadMessageCSSValue(MailPage mailPage, String property) {
        return mailPage.openMessage()
                .inboxClick()
                .getMessageAddressee()
                .getCssValue(property);
    }

    public static String getUnreadMessageCSSValue(MailPage mailPage, String property) {
        return mailPage.getMessageAddressee().getCssValue(property);
    }
}
