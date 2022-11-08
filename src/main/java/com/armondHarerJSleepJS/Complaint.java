package com.armondHarerJSleepJS;

import com.armondHarerJSleepJS.dbjson.Serializable;
/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable
{
    // instance variables - replace the example below with your own
    public String date;
    public String desc;

    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(String date, String desc)
    {
        // initialise instance variables
    	super();
        this.date = date;
        this.desc = desc;
    }

    public String toString()
    {
        // put your code here
        return "Complaint File\nDate : " + date + "\nDescription : " + desc;
    }
}
