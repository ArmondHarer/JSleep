package com.armondHarerJSleepJS;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Mengelola transaksi dalam JSleep
 * @author Armond Harer
 */
public class Payment extends Invoice
{
    
    private int roomId;
    public Date to;
    public Date from;

    /**
     * Membuat object Payment baru
     * 
     * @param buyerId 	| ID pelanggan
     * @param renterId	| ID renter
     * @param roomId	| ID ruangan yang akan disewa
     * @param from		| Tanggal awal penyewaan
     * @param to		| Tanggal akhir penyewaan
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;

    }
    
    /**
     * Membuat object Payment baru
     * 
     * @param buyer 	| Informasi akun pelanggan
     * @param renter	| Informasi renter
     * @param roomId	| ID ruangan yang akan disewa
     * @param from		| Tanggal awal penyewaan
     * @param to		| Tanggal akhir penyewaan
     */
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * @return ID dari room (karena bersifat private)
     */
    public int getRoomId()
    {
        return roomId;
    }
    
    /**
     * 
     * @param from | Tanggal awal penyewaan
     * @param to   | Tanggal akhir penyewaan
     * @param room | Ruangan yang akan disewa
     * @return boolean apabila ruangan tersebut tersedia untuk interval tanggal tersebut
     */
    public static boolean availability(Date from, Date to, Room room){
    	Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
    	
    	if(start.after(end) || start.equals(end))
        {return false;}
        if(room.booked.isEmpty())
        {return true;}
        for(Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()){
            if(room.booked.contains(date))
            	return false;
        }
        return true;
    }
    
    /**
     * 
     * @param from | Tanggal awal penyewaan
     * @param to   | Tanggal akhir penyewaan
     * @param room | Ruangan yang akan disewa
     * @return boolean konfirmasi booking untuk ruangan yang akan disewa
     */
    public static boolean makeBooking(Date from, Date to, Room room){
        if(to.before(from))
        	return false;
        
        if(availability(from, to, room)) {
        	while(from.before(to)) {
        		room.booked.add(from);
        		Calendar cal = Calendar.getInstance();
        		cal.setTime(from);
        		cal.add(Calendar.DATE, 1);
        		from = cal.getTime();
        	}
        	return true;
        }
        return false;
    }
   
}
