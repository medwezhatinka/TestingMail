/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test;

import by.epam.lab.test.datareader.XLSReader;

/**
 *
 * @author Alina_Shumel
 */
public class TestHelper {
    
   private  String url;
    private String email;
    private String password;
    
    
    
  
    public  TestHelper(){
       setUrl();
       setEmail();
       setPassword();;
      
    }

    public String getUrl() {
        return url;
    }

    public void setUrl() {
       this.url = XLSReader.getData("testdata.xlsx", "global", "StartURL")[0].toString() ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = XLSReader.getData("testdata.xlsx", "global", "Username")[0].toString() ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = XLSReader.getData("testdata.xlsx", "global", "Password")[0].toString() ;
    }
    
    
    
    
}
