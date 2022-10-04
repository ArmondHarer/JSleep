package armondHarerJSleepJS;

import java.util.Calendar;
import java.text.SimpleDateFormat;
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
    public PaymentStatus status;
    public RoomRating rating;
    public Calendar time;

    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int id, int buyerID, int renterID)
    {
        // initialise instance variables
        super(id);
        this.buyerID = buyerID;
        this.renterID = renterID;
        this.time = Calendar.getInstance();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    public Invoice(int id, Account buyer, Renter renter)
    {
        // initialise instance variables
        super(id);
        this.buyerID = buyerID;
        this.renterID = renterID;
        this.time = Calendar.getInstance();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    public String print()
    {
        String buffer = "ID : " + super.id + "\nBuyer ID : " + buyerID + "\nRenter ID : " + 
        renterID + "\n Time : " + time;
        return buffer;
    }
    
    public enum RoomRating{
        NONE,BAD,NEUTRAL,GOOD
    }
    
    public enum PaymentStatus{
        FAILED,WAITING,SUCCESS
    }
}
