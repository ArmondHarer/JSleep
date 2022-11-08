package com.armondHarerJSleepJS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.armondHarerJSleepJS.dbjson.Serializable;

/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String username;
    public String address;
    public String phonenumber;

    /**
     * Constructor for objects of class Renter
     */
    public static final String REGEX_NAME = "[A-Z][A-Za-z0-9_]{5,21}";
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    
    public Renter(String username, String address, String phonenumber)
    {
        // initialise instance variables
    	super();
        this.username = username;
        this.address = address;
        this.phonenumber = phonenumber;
    }
    
    public boolean validate () {
    	Pattern emailPattern = Pattern.compile(REGEX_NAME);
        Matcher emailMatcher = emailPattern.matcher(this.username);

        Pattern passwordPattern = Pattern.compile(REGEX_PHONE);
        Matcher passwordMatcher = passwordPattern.matcher(this.phonenumber);

        return emailMatcher.matches() && passwordMatcher.matches();
    }
    /*public Renter(String username)
    {
        // initialise instance variables
        this.username = username;
        this.phonenumber = 0;
        this.address = "";
    }

    public Renter(String username, String address)
    {
        // initialise instance variables
        this.username = username;
        this.address = address;
        this.phonenumber = 0;
    }   
    
    public Renter(String username, int phonenumber)
    {
        // initialise instance variables
        this.username = username;
        this.phonenumber = phonenumber;
        this.address = "";
    }
    */
}
