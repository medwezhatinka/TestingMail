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
    public static  final String addEmailWindowEmail = "//div[@class='PN']/input";
    public static  final String addEmailWindowNext = "next";
    public static  final String addEmailWindowOk = "ok";
    
    //LargeFileAllertDialog
    public static final String largeFileAllertMessage="span.Kj-JD-K7-K0";
    public static final String largeFileAllertCancel="span.Kj-JD-K7-Jq";
    
    //LoginForm
    public static final String loginFormEmail="Email";
    public static  final String loginFormPassword="Passwd";
    public  static final String loginFormSignInButton="signIn";
    
    //MailTable
    public static final  String mailTableAddr=".//td[@class='yX xY ']/div[@class='yW']/span";
    public static final  String mailTableSubject=".//td[@class='xY ']/.//span[@class='y2']/preceding-sibling::span";
    public static final  String mailTableText=".//td[@class='xY ']/.//span[@class='y2']";
    public static final  String mailTableTime=".//td[@class='xW xY ']/span";
    
    //MessageSendTable
    public static final String sendMessageTo="//textarea[@name='to']";
    public static final String sendMessageSubject="subjectbox";
    public static final String sendMessageSendButton="//div[text()='Send']";
    public static final String sendMessageIFrame="//div[@class='Am Al editable']/iframe";
    public static final String sendMessageCloseButton="//table[@class='cf Ht']/tbody/tr/td[2]/img[@alt='Close']";
    public static final String sendMessageAttachButton="//table[@class='IZ']/tbody/tr/td[4]/div";
    
    //OptionsPanel
     public static final String optionsPanelArchive="//div[@aria-label='Archive']";
     public static final String optionsPanelReportSpam="//div[@aria-label='Report spam']";
     public static final String optionsPanelDelete="//div[@aria-label='Delete']";
     public static final String optionsPanelLabels="//div[@aria-label='Labels']";
     public static final String optionsPanelMoveTo="//div[@aria-label='Move to']";
     public static final String optionsPanelSelect="//div[@aria-label='Select']";
     
     
}
