package armondHarerJSleepJS;


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
    public String address = "";
    public int phonenumber = 0;

    /**
     * Constructor for objects of class Renter
     */
    public Renter(int id, String username)
    {
        // initialise instance variables
        super(id);
        this.username = username;
    }

    public Renter(int id, String username, String address)
    {
        // initialise instance variables
        super(id);
        this.username = username;
        this.address = address;
    }   
    
    public Renter(int id, String username, int phonenumber)
    {
        // initialise instance variables
        super(id);
        this.username = username;
        this.phonenumber = phonenumber;
    }
    
    public Renter(int id, String username, String address, int phonenumber)
    {
        // initialise instance variables
        super(id);
        this.username = username;
        this.address = address;
        this.phonenumber = phonenumber;
    }
}
