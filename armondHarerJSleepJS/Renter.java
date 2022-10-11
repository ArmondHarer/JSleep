package armondHarerJSleepJS;


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
    public int phonenumber;

    /**
     * Constructor for objects of class Renter
     */
    public Renter(String username)
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
    
    public Renter(String username, String address, int phonenumber)
    {
        // initialise instance variables
        this.username = username;
        this.address = address;
        this.phonenumber = phonenumber;
    }
}
