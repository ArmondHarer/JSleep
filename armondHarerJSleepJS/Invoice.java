package armondHarerJSleepJS;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    // instance variables - replace the example below with your own
    public int buyerID;
    public int renterID;
    public String time;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, int buyerID, int renterID, String time)
    {
        // initialise instance variables
        super(id);
        this.buyerID = buyerID;
        this.renterID = renterID;
        this.time = time;
    }
    
    public Invoice(int id, Account buyer, Renter renter, String time)
    {
        // initialise instance variables
        super(id);
        this.buyerID = buyerID;
        this.renterID = renterID;
        this.time = time;
    }
    
    public String print()
    {
        String buffer = "Buyer ID : " + buyerID + ", Renter ID : " + renterID + ", Time : " + time;
        return buffer;
    }
}
