package com.armondHarerJSleepJS;

import java.util.Date;

/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    private int roomId;
    public Date to;
    public Date from;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to)
    {
        // initialise instance variables
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;

    }
    
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        // initialise instance variables
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public int getRoomId()
    {
        return roomId;
    }
    
    public static boolean availability(Date from, Date to, Room room){
        if(to.compareTo(from) < 0)
        {return false;}
        if(room.booked.isEmpty())
        {return true;}
        for(int i = 0; i < room.booked.size(); i +=2){
            if(to.after(room.booked.get(i)) && to.before(room.booked.get(i+1)))
            {return false;}
            else if(from.after(room.booked.get(i)) && from.before(room.booked.get(i+1)))
            {return false;}
        }
        return true;
    }
    
    public static boolean makeBooking(Date from, Date to, Room room){
        if(Payment.availability(from, to, room)){
            room.booked.add(from);
            room.booked.add(to);
            return true;
        }
        else {return false;}
    }
    /*public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        String waktu = sdf.format(time.getTime());
        return "Current date : " + waktu;
    }
    
    
    public String print()
    {
        // put your code here
        return ("to : " + to + "\n from : " + from + "\n Room ID : " + roomId);
    }*/
    
    /*public String getDuration(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        this.to = Calendar.getInstance();
        this.from = Calendar.getInstance();
        to.add(Calendar.DATE, 2);
        String tglto = sdf.format(to.getTime());
        String tglfrom = sdf.format(from.getTime());
        return tglfrom + "-" + tglto;
    };
    */
}
