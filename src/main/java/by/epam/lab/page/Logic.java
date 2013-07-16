/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.page;

/**
 *
 * @author Alina_Shumel
 */
public class Logic {
    
    
    public static String substringAfter(String text,String string, int length){
       
        int position = text.indexOf(string);
        position += string.length()+1;
        
        String  code = text.substring(position, position+length);
        System.out.println(code);
        
        return code;
        
    }
    
}
