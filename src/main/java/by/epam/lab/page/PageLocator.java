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
    public static final String ALERTDIALOG_ACCEPT_BUTTON = "html.aAX body.aAU div.Kj-JD div.Kj-JD-Jl button.J-at1-auR";
    
    //LoginPage
    public static final String LOGINFORM = "gaia_loginform";
    public static final String EMAIL_ERROR ="errormsg_0_Email";
    public static final String PASSWORD_ERROR="errormsg_0_Passwd";
    
    //MailTablePage
    public static final String MAILTABLE = ".//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]";
   
    //MailPage
    public static final String COMPOSE_BUTTON = "//div[text()='COMPOSE']";
    public static final String MESSAGE_TABLE = "//table[@class='F cf zt']";
    public static final String INBOX = "//div[@class='ajl aib lKgBkb']/div/div/div/div/div/div/div/div/span/a";
    public static final String OPTIONS = "//div[@class='nH aqK']";
    public static final String MORE = "div.n6 span";
    public static final String TRASH = "//a[@title='Trash']";
    public static final String SPAM = "//div/div/div[2]/div/div[3]/div/div/div/div[3]/div/div/div/span[@class='nU n1']/a";
    public static final String ALL_MAIL = "//div/div/div/div[2]/div/div/div/span/a[@title='All Mail']";
    public static final String SETTINGS = "//div[@class='nH']/div/div[2]/div/div[2]/div/div/div/div/div/div/div[2]/div[2]/div";
    public static final String SETTINGS_SETTINGS = "//div[@id='ms']/div";
    public static final String NEW_MESSAGE_WINDOW = "//table[@class='cf Ht']/tbody/tr/td/div";
    public static final String ADDRESSEE = "//tr/td[5]/div/span";
    public static final String SUBJECT = "//tr/td[6]/div//div/div/span";
    public static final String TEXT = "//tr/td[6]/div//div/div/span[2]";
    public static final String TIME = "//tr/td[8]/span";
    public static final String LOGOUT_BUTTON_PANEL = "gbg4";
    public static final String LOGOUT_BUTTON = "gb_71";
    public static final String MESSAGE_MOVE = "//div[@class='AO']/div/div/div[1]/div[2]/div[4]/div[@class='Cp']/div/table[1]/tbody/tr[1]";
    public static final String MESSAGE_CHECKBOX="//tr/td[2]/div/div"; 
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
    public static final String VERIFY_BUTTON = "//div[@class='nH Tv1JD']/div/table/tbody/tr[1]/td[2]/div/div[3]/table/tbody/tr[4]/td[2]/input[@value='Verify']";
    public static final String VERIFY_CODE_INPUT = "//div[@class='nH Tv1JD']/div/table/tbody/tr[1]/td[2]/div/div[3]/table/tbody/tr[4]/td[2]/input[1]";
    public static final String PROCEED_BUTTON = "//input[@value='Proceed']";
    public static final String FORM_WITH_EMAIL = "//div[@class='Kj-JD-Jz']/iframe";
    public static final String MESSAGES = "//table[@class='F cf zt']";
    public static final String FORWARDING_ON = "//div/table[2]/tbody/tr/td/input[@name='sx_em']";
    public static final String REMOVE_FORWARDING = "//table[@class='cf']/tbody/tr/td[2]/div/div/table[2]/tbody/tr/td[2]/span/select[1]";
    public static final String FORWARD_DIALOD = "//body/div[@class='Kj-JD']";
}
