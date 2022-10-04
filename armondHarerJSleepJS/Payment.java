package armondHarerJSleepJS;

import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public Calendar to;
    public Calendar from;
    private int roomID;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerID, int renterID, int roomID)
    {
        // initialise instance variables
        super(id, buyerID, renterID);
        this.roomID = roomID;
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomID, String from)
    {
        // initialise instance variables
        super(id, buyer, renter);
        this.roomID = roomID;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        String waktu = sdf.format(time.getTime());
        return "Current date : " + waktu;
    }
    
    public String getDuration(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        this.to = Calendar.getInstance();
        this.from = Calendar.getInstance();
        to.add(Calendar.DATE, 2);
        String tglto = sdf.format(to.getTime());
        String tglfrom = sdf.format(from.getTime());
        return tglfrom + "-" + tglto;
    };
    
    public String print()
    {
        // put your code here
        return ("to : " + to + "\n from : " + from + "\n Room ID : " + roomID);
    }
    
    public int getRoomID()
    {
        return roomID;
    }
}
