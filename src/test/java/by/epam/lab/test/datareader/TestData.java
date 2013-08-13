/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.datareader;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumMap;

/**
 *
 * @author Alina_Shumel
 */
public class TestData {

    public static EnumMap<Key, String> data;

    protected enum Key {

        START_URL, MAIL_PAGE_LOCATION,
        CORRECT_EMAIL_PART_TEST, CORRECT_EMAIL_TEST, CORRECT_PASSWORD_TEST,
        INCORRECT_PASSWORD_TEST, MESSAGE_INCORRECT_PASSWORD_OR_EMAIL, LOGIN_PAGE_LOCATION,
        HOME_PAGE_URL, SUBJECT, TEXT, ME, INCORRECT_EMAIL_MESSAGE, INCORRECT_EMAIL,
        NO_RECIPIENT_MESSAGE, SCRIPT_PATH, SMALL_FILE_PATH, LARGE_FILE_PATH,
        LARGE_FILE_MESSAGE, BOLD, NORMAL, SIGNATURE, ENTER_EMAIL_MESSAGE, QUOTED_USERNAME,
        CORRECT_EMAIL_TESTOID, CORRECT_PASSWORD_TESTOID, CORRECT_EMAIL_TESTEROVSKI,
        CORRECT_PASSWORD_TESTEROVSKI, NAME, CONFIRMATION_CODE, FONT_WEIGHT
    }

    public static void initialize() throws FileNotFoundException, IOException {
        data = new EnumMap<Key, String>(Key.class);
        XLSReader.getData("testdata.xlsx", "data", data);
    }

    public static String get(Key key) {
        return data.get(Key.CORRECT_EMAIL_TEST);
    }
}
