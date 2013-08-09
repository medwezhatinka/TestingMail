/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element;

/**
 *
 * @author Alina_Shumel
 */
public interface Locator {
    
    //AddEmailWindow
    public static final String ADDEMAILWINDOW_EMAIL = "//div[@class='PN']/input";
    public static final String ADDEMAILWINDOW_NEXT = "next";
    public static final String ADDEMAILWINDOW_OK = "ok";
    
    //LargeFileAllertDialog
    public static final String LARGEFILEALERT_MESSAGE = "span.Kj-JD-K7-K0";
    public static final String LARGEFILEALERT_CANCEL = "span.Kj-JD-K7-Jq";
   
    //LoginForm
    public static final String LOGINFORM_EMAIL = "Email";
    public static final String LOGINFORM_PASSWORD = "Passwd";
    public static final String LOGINFORM_SIGN_IN_BUTTON = "signIn";
    
    //MailTable
    public static final String MAILTABLE_ADDR = ".//td[@class='yX xY ']/div[@class='yW']/span";
    public static final String MAILTABLE_SUBJECT = ".//td[@class='xY ']/.//span[@class='y2']/preceding-sibling::span";
    public static final String MAILTABLE_TEXT = ".//td[@class='xY ']/.//span[@class='y2']";
    public static final String MAILTABLE_TIME = ".//td[@class='xW xY ']/span";
    
    //MessageSendTable
    public static final String SENDMESSAGE_TO = "//textarea[@name='to']";
    public static final String SENDMESSAGE_SUBJECT = "subjectbox";
    public static final String SENDMESSAGE_SEND_BUTTON = "//div[text()='Send']";
    public static final String SENDMESSAGE_IFRAME = "//div[@class='Am Al editable']/iframe";
    public static final String SENDMESSAGE_CLOSE_BUTTON = "//table[@class='cf Ht']/tbody/tr/td[2]/img[@alt='Close']";
    public static final String SENDMESSAGE_ATTACH_BUTTON = "//table[@class='IZ']/tbody/tr/td[4]/div";
    
    //OptionsPanel
    public static final String OPTIONSPANEL_ARCHIVE = "//div[@aria-label='Archive']";
    public static final String OPTIONSPANEL_REPORT_SPAM = "//div[@aria-label='Report spam']";
    public static final String OPTIONSPANEL_DELETE = "//div[@aria-label='Delete']";
    public static final String OPTIONSPANEL_LABELS = "//div[@aria-label='Labels']";
    public static final String OPTIONSPANEL_MOVE_TO = "//div[@aria-label='Move to']";
    public static final String OPTIONSPANEL_SELECT = "//div[@aria-label='Select']";
}
