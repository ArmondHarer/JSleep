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
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;
    public Calendar time;

    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int id, int buyerId, int renterId)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    public Invoice(int id, Account buyer, Renter renter)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    public String print()
    {
        String buffer = "ID : " + super.id + "\nBuyer ID : " + buyerId + "\nRenter ID : " + 
        renterId + "\n Time : " + time;
        return buffer;
    }
    
    public enum RoomRating{
        NONE,BAD,NEUTRAL,GOOD
    }
    
    public enum PaymentStatus{
        FAILED,WAITING,SUCCESS
    }
}
