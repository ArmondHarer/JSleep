package armondHarerJSleepJS;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public String to;
    public String from;
    private int roomID;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerID, int renterID, String time, int roomID, String from, String to)
    {
        // initialise instance variables
        super(id, buyerID, renterID, time);
        this.roomID = roomID;
        this.from = from;
        this.to = to;
    }
    
    public Payment(int id, Account buyer, Renter renter, String time, int roomID, String from, String to)
    {
        // initialise instance variables
        super(id, buyer, renter, time);
        this.roomID = roomID;
        this.from = from;
        this.to = to;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String print()
    {
        // put your code here
        return ("to : " + to + "; from : " + from + "; Room ID : " + roomID);
    }
    
    public int getRoomID()
    {
        return roomID;
    }
}
