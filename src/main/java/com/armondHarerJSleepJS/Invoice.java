package com.armondHarerJSleepJS;

import com.armondHarerJSleepJS.dbjson.Serializable;
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


    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int buyerId, int renterId)
    {
        // initialise instance variables
    	super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        // this.time = new Date();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    public Invoice(Account buyer, Renter renter)
    {
        // initialise instance variables
        this.buyerId = buyerId;
        this.renterId = renterId;
        // this.time = new Date();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    public String print()
    {
        String buffer = "\nBuyer ID : " + buyerId + "\nRenter ID : " + 
        renterId;
        return buffer;
    }
    
    public enum RoomRating{
        NONE,BAD,NEUTRAL,GOOD
    }
    
    public enum PaymentStatus{
        FAILED,WAITING,SUCCESS
    }
}
