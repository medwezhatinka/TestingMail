/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

/**
 *
 * @author Alina_Shumel
 */
public interface PageLocator {

    //AbstractPage
    public static final String ALERT_DIALOG = "//div[@class='Kj-JD']";
    public static final String ALERTDIALOG_ALERT_TEXT = "span.Kj-JD-K7-K0";
    public static final String ALERTDIALOG_TEXT = "div.Kj-JD-Jz";
    public static final String ALERTDIALOG_ACCEPT_BUTTON = "button[name='ok']";
    
    //LoginPage
    public static final String LOGINFORM = "gaia_loginform";
    public static final String EMAIL_ERROR ="errormsg_0_Email";
    public static final String PASSWORD_ERROR="errormsg_0_Passwd";
    
    //MailTablePage
    public static final String MAILTABLE = ".//div[@gh='tl']/div/div/table/tbody";
   
    //MailPage
    public static final String COMPOSE_BUTTON = "//div[text()='COMPOSE']";
    public static final String MESSAGE_TABLE = ".//div[@gh='tl']/div/div/table";
    public static final String INBOX = "//span[@class='nU n1']/a[@class='J-Ke n0']";
    public static final String OPTIONS = "//div[@class='nH aqK']";
    public static final String MORE = "div.n6 span";
    public static final String TRASH = "//a[@title='Trash']";
    public static final String SPAM = "//a[contains(.,'Spam')]";
    public static final String ALL_MAIL = "//a[@title='All Mail']";
    public static final String SETTINGS = ".//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']";
    public static final String SETTINGS_SETTINGS = "//div[@id='ms']/div";
    public static final String NEW_MESSAGE_WINDOW = "//div[@class='AD']";
    public static final String ADDRESSEE = "//span[@class='zF']";
    public static final String SUBJECT = "//div [@class='y6']/span";
    public static final String TEXT = "//div [@class='y6']/span[2]";
    public static final String TIME = "//tr/td[8]/span";
    public static final String LOGOUT_BUTTON_PANEL = "gbg4";
    public static final String LOGOUT_BUTTON = "gb_71";
    public static final String MESSAGE_MOVE = ".//div[@gh='tl']/div/div/table/tbody/tr[1]";
    public static final String MESSAGE_CHECKBOX=".//div[@role='checkbox']"; 
    public static final String SPAN = ".//span";
    public static final String DIV = ".//div";
    public static final String FONT_WEIGHT = "font-weight";
    public static final String ARIA_CHECKED= "aria-checked";
    
    //OpenedMessage
    public static final String SHOW_ALL_CONTENT = "//div[@aria-label='Show trimmed content']";
    public static final String SIGNATURE = "//span[@class='HOEnZb adL']/font/div/div";
    public static final String MESSAGE_BODY = "//div[@class='gs']/div[6]/div";
    
    //SendMessagePage
    public static final String NEW_EMAIL = "div.aaZ";
    public static final String LARGE_FILE_ALERT = "div.Kj-JD";
    public static final String SUCCESSFUL_SEND = ".//div[@class='vh']";
    public static final String SUCCESSFUL_SEND_TEXT = "Your message has been sent.";
    public static final String SUCCESSFUL_ATTACH = "//div[text()='%s']/following-sibling::div[text()='%s']";
    
    //Settings
    public static final String SETTINGS_TITLE = "//h2[text()='Settings']";
    public static final String SIGNATURE_ON = "//input[@name='sx_sg']";
    public static final String SIGNATURE_IFRAME = "//div[@aria-label='Signature']/iframe";
    public static final String SIGNATURE_INPUT = "body";
    public static final String SAVE_CHANGES_BUTTON = ".//button[contains(.,'Save Changes')]";
    public static final String FORWARDING_TAB = "//a[text()='Forwarding and POP/IMAP']";
    public static final String ADD_ADDRESS_BUTTON = "//input[@value='Add a forwarding address']";
    public static final String ADD_ADDDRESS_WINDOW = "//body/div[@class='Kj-JD']";
    public static final String VERIFY_BUTTON = "//input[@act='verify']";
    public static final String VERIFY_CODE_INPUT = "//input[@act='verifyText']";
    public static final String PROCEED_BUTTON = "//input[@value='Proceed']";
    public static final String FORM_WITH_EMAIL = "//div[@class='Kj-JD-Jz']/iframe";
    public static final String MESSAGES = ".//div[@gh='tl']/div/div/table";
    public static final String FORWARDING_ON = "//div/table[2]/tbody/tr/td/input[@name='sx_em']";
    public static final String REMOVE_FORWARDING = "//span[contains(.,'Forward a copy')]/select[1]";
    public static final String FORWARD_DIALOD = "//body/div[@class='Kj-JD']";
}
