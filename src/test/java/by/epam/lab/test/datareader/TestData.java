/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.datareader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Alina_Shumel
 */
public class TestData {

    private static String FILENAMEINPUT = "testdata.properties";
    public static String START_URL;// = "http://mail.google.com";
    public static String MAIL_PAGE_LOCATION;// = "https://mail.google.com/mail/";
    public static String CORRECT_EMAIL_PART_TEST;// = "test.auto.lab";
    public static String CORRECT_EMAIL_TEST;// = "test.auto.lab@gmail.com";
    public static String CORRECT_PASSWORD_TEST;// = "testautolab";
    public static String INCORRECT_PASSWORD_TEST;//= "testautolab123";
    public static String MESSAGE_INCORRECT_PASSWORD_OR_EMAIL;// = "The username or password you entered is incorrect. ?";
    public static String LOGIN_PAGE_LOCATION;// = "https://accounts.google.com/ServiceLogin";
    public static String HOME_PAGE_URL;// = "http://www.gmail.com";
    public static String SUBJECT;
    public static String TEXT;
    public static String ME;
    public static String INCORRECT_EMAIL_MESSAGE;
    public static String INCORRECT_EMAIL;
    public static String NO_RECIPIENT_MESSAGE;
    public static String SCRIPT_PATH;
    public static String SMALL_FILE_PATH;
    public static String LARGE_FILE_PATH;
    public static String LARGE_FILE_MESSAGE;
    public static String BOLD;
    public static String NORMAL;
    public static String SIGNATURE;
    public static String ENTER_EMAIL_MESSAGE;
    public static String QUOTED_USERNAME;
    public static String CORRECT_EMAIL_TESTOID;// = "testoid2013@gmail.com";
    public static String CORRECT_PASSWORD_TESTOID;// = "559283test";
    public static String CORRECT_EMAIL_TESTEROVSKI;
    public static String CORRECT_PASSWORD_TESTEROVSKI;
    public static String NAME;
    public static String CONFIRMATION_CODE;
    public static String FONT_WEIGHT;

    public static void initialize() throws FileNotFoundException, IOException {
        File source = new File(FILENAMEINPUT);
        FileInputStream fis = new FileInputStream(source);
        Properties p = new Properties();
        p.load(fis);

        START_URL = p.getProperty("START_URL");
        MAIL_PAGE_LOCATION = p.getProperty("MAIL_PAGE_LOCATION");
        CORRECT_EMAIL_PART_TEST = p.getProperty("CORRECT_EMAIL_PART_TEST");
        CORRECT_EMAIL_TEST = p.getProperty("CORRECT_EMAIL_TEST");
        CORRECT_PASSWORD_TEST = p.getProperty("CORRECT_PASSWORD_TEST");
        INCORRECT_PASSWORD_TEST = p.getProperty("INCORRECT_PASSWORD_TEST");
        MESSAGE_INCORRECT_PASSWORD_OR_EMAIL = p.getProperty("MESSAGE_INCORRECT_PASSWORD_OR_EMAIL");
        LOGIN_PAGE_LOCATION = p.getProperty("LOGIN_PAGE_LOCATION");
        HOME_PAGE_URL = p.getProperty("HOME_PAGE_URL");
        SUBJECT = p.getProperty("SUBJECT");
        TEXT = p.getProperty("TEXT");
        ME = p.getProperty("ME");
        INCORRECT_EMAIL_MESSAGE = p.getProperty("INCORRECT_EMAIL_MESSAGE");
        INCORRECT_EMAIL = p.getProperty("INCORRECT_EMAIL");
        NO_RECIPIENT_MESSAGE = p.getProperty("NO_RECIPIENT_MESSAGE");
        SCRIPT_PATH = p.getProperty("SCRIPT_PATH");
        SMALL_FILE_PATH = p.getProperty("SMALL_FILE_PATH");
        LARGE_FILE_PATH = p.getProperty("LARGE_FILE_PATH");
        LARGE_FILE_MESSAGE = p.getProperty("LARGE_FILE_MESSAGE");
        BOLD = p.getProperty("BOLD");
        NORMAL = p.getProperty("NORMAL");
        SIGNATURE = p.getProperty("SIGNATURE");
        ENTER_EMAIL_MESSAGE = p.getProperty("ENTER_EMAIL_MESSAGE");
        QUOTED_USERNAME = p.getProperty("QUOTED_USERNAME");
        CORRECT_EMAIL_TESTOID = p.getProperty("CORRECT_EMAIL_TESTOID");
        CORRECT_PASSWORD_TESTOID = p.getProperty("CORRECT_PASSWORD_TESTOID");
        CORRECT_EMAIL_TESTEROVSKI = p.getProperty("CORRECT_EMAIL_TESTEROVSKI");
        CORRECT_PASSWORD_TESTEROVSKI = p.getProperty("CORRECT_PASSWORD_TESTEROVSKI");
        NAME = p.getProperty("NAME");
        CONFIRMATION_CODE = p.getProperty("CONFIRMATION_CODE");
        FONT_WEIGHT = p.getProperty("FONT_WEIGHT");



    }
}
