package armondHarerJSleepJS;

import java.util.regex.Pattern;

/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter
{
    // instance variables - replace the example below with your own
    public String username;
    public String address;
    public String phonenumber;

    /**
     * Constructor for objects of class Renter
     */
    public static final Pattern REGEX_NAME = Pattern.compile("[A-Z][A-Za-z0-9_]{5,21}");
    public static final Pattern REGEX_PHONE = Pattern.compile("[0-9]{9,12}");
    
    public Renter(String username, String address, String phonenumber)
    {
        // initialise instance variables
        this.username = username;
        this.address = address;
        this.phonenumber = phonenumber;
    }
    
    public boolean validate () {
    	return (REGEX_PHONE.matcher(phonenumber).matches()) && (REGEX_NAME.matcher(username).matches());
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
