/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.logic.SendMessage;
import by.epam.lab.logic.Signature;
import by.epam.lab.test.preparation.MessagePreparation;
import by.epam.lab.page.OpenedMessage;
import static by.epam.lab.test.datareader.TestData.data;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author Alina_Shumel
 */
@Listeners(value = by.epam.lab.test.listener.TestListener.class)
public class AddSignature extends MessagePreparation {

    private OpenedMessage openedMessage;

    @Test(enabled = true, groups = {MESSAGE})
    public void signatureAdd() {
        Assert.assertEquals(openedMessage.getSignatureText(), data.get(Key.SIGNATURE));
    }

    @BeforeMethod(groups = MESSAGE)
    @Override
    public void tearUpMethod() {
        Signature.addSignature(mailPage, data.get(Key.SIGNATURE));
        SendMessage.sendCorrectMessage(mailPage, data.get(Key.CORRECT_EMAIL_TEST),
                data.get(Key.SUBJECT), data.get(Key.TEXT));
        mailPage.openMessage();
        openedMessage = new OpenedMessage();
    }

    @AfterMethod(groups = MESSAGE)
    @Override
    public void tearDownMethod() {
        Signature.removeSignature(mailPage);
    }
}
