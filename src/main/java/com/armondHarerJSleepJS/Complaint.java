package com.armondHarerJSleepJS;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.armondHarerJSleepJS.dbjson.Serializable;

/**
 * Complaint untuk room yang disewa
 * @author Armond Harer
 */
public class Complaint extends Serializable
{
    // instance variables - replace the example below with your own
    Date date;
    public String desc;

    /**
     * @Param desc | Deskripsi keluhan pelanggan
     */
    public Complaint(String desc)
    {
    	super();
        this.date = new Date();
        this.desc = desc;
    }

    /**
    * @return informasi keluhan dalam bentuk string
    */
    public String toString()
    {
    	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	 String simpledate = dateFormat.format(this.date);

        // put your code here
        return "Complaint File\nDate : " + simpledate + "\nDescription : " + desc;
    }
}
