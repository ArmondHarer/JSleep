package com.armondHarerJSleepJS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.armondHarerJSleepJS.dbjson.Serializable;

/*
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
/*public class Account
{
    // instance variables - replace the example below with your own
    public String name;
    public String email;
    public String password;
}*/

public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d]{8,}$";
    
    public Account(String name, String email, String password)
    {
    	super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public boolean validate() {

        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher emailMatcher = emailPattern.matcher(this.email);

        Pattern passwordPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher passwordMatcher = passwordPattern.matcher(this.password);

        return emailMatcher.matches() && passwordMatcher.matches();
        
    }
    
    public String toString()
    {
        return "Account Information\nName : " + name + "\nEmail Address : " + email  + "\nPassword : " + password;
    }
    
    /*
    
    
    public Object write(){
        return null;
    }

    public boolean read(String content){
    return false;
    }
    */
}
