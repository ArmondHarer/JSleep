package com.armondHarerJSleepJS;

import java.util.*;
import com.armondHarerJSleepJS.dbjson.Serializable;
import com.armondHarerJSleepJS.*;

/**
 * Class untuk Room dalam JSleep
 * @author Armond Harer
 */
public class Room extends Serializable
{
    public int size;
    public String name;
    public Price price;
    public ArrayList<Facility> facility = new ArrayList<>();
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList <Date> booked = new ArrayList<Date>();
    public int accountId;
    
    /**
     * 
     * @param name		| Nama kamar
     * @param size		| Ukuran kamar (dalam m2)
     * @param price		| Harga kamar
     * @param facilList	| Fasilitas-fasilitas kamar
     * @param city		| Kota lokasi kamar
     * @param address	| Alamat kamar
     * @param accountID	| Account ID yang terikat pada kamar
     */
    public Room(String name, int size, Price price, ArrayList<Facility> facilList,City city, BedType bedtype, String address, int accountId){
        super();
    	this.name = name;
        this.size = size;
        this.price = price;
        this.facility.addAll(facilList);
        this.city = city;
        this.address = address;
        this.accountId = accountId;
        this.bedType = bedtype;
        this.booked = new ArrayList<Date>();
    }
    
    /**
     * @return informasi room dalam bentuk string
     */
    public String toString(){
        return "Room Information : \nName: " + name + "\nSize: " + size + "m^2\nPrice: $" + price + "\nFacility: " + facility + "\nCity: " + city + "\nAddress: " + address + "\nBed Type: " + bedType;
    }
    
}
