package com.armondHarerJSleepJS;

import com.armondHarerJSleepJS.dbjson.Serializable;
import java.util.Date;

/**
 * Invoice setelah pelanggan menyewa kamar
 * @author Armond Harer
 */
public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;


    /**
     * @param buyerId	| ID dari pelanggan
     * @param renterId	| ID dari penyewa
     */
    protected Invoice(int buyerId, int renterId)
    {
    	super();
    	
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    /**
     * Invoice setelah pelanggan menyewa kamar
     * 
     * @param buyer		| Informasi akun pembeli
     * @param renter	| Informasi renter
     */
    public Invoice(Account buyer, Renter renter)
    {
        // initialise instance variables
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }
    
    /*
     * Meng-return ID dari pembeli dan renter
     */
    public String print()
    {
        return "\nBuyer ID : " + buyerId + "\nRenter ID : " + renterId;
    }
    
    /*
     * rating dari kamar
     */
    public enum RoomRating{
        NONE,BAD,NEUTRAL,GOOD
    }
    
    /*
     * Status pembayaran untuk kamar
     */
    public enum PaymentStatus{
        FAILED,WAITING,SUCCESS
    }
}
