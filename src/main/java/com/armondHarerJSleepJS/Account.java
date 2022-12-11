package com.armondHarerJSleepJS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.armondHarerJSleepJS.dbjson.Serializable;

/**
 * Class untuk account JSleep
 * @author Armond Harer
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public Renter renter;
    public String password;
    public Double balance;
    
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z](?!.*\\.)";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?!.*\\s)[a-zA-Z0-9_\\W]{8,}$";
    
    /**
    *
    * @param name     | nama user
    * @param email    | email user
    * @param password | password user
    * @param balance  | balance dari user
    */
    public Account(String name, String email, String password, Double balance)
    {
    	super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.renter = null;
    }
    
    /**
    *
    * @return validasi pencocokan email dan password terhadap regex
    */
    public boolean validate() {
    	Pattern patternEmail = Pattern.compile(this.REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(this.email);
        boolean matchFoundEmail = matcherEmail.find();
        
        Pattern patternPassword = Pattern.compile(this.REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(this.name);
        boolean matchFoundPassword = matcherPassword.find();
        
        return matchFoundEmail && matchFoundPassword;
    }
    
    /**
    *
    * @return informasi akun dalam bentuk string
    */
    public String toString()
    {
        return "Account Information\nName : " + name + "\nEmail Address : " + email  + "\nPassword : " + password;
    }

}
