package com.armondHarerJSleepJS;

import com.armondHarerJSleepJS.dbjson.Serializable;
import com.armondHarerJSleepJS.Price;

/**
 * Class Voucher untuk pemotongan harga
 * @author Armond Harer
 */
public class Voucher extends Serializable
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    
    /**
     * @param name		| nama voucher
     * @param code		| kode promo dalam voucher
     * @param type 		| jenis promo voucher (diskon/rebat)
     * @param cut  		| potongan harga voucher
     * @param minimum 	| minimum pembayaran agar voucher berlaku
     */
    public Voucher (String name, int code, Type type, boolean used, double minimum, double cut)
    {
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
    }
    
    /**
    * @return boolean apabila voucher telah digunakan
    */
    
    public boolean isUsed()
    {
    	return this.used;
    }
    
    /**
    * @param price 	| Harga Room
    * @return boolean apabila harga minimum tercapai
    */
    public boolean canApply(Price price)
    {
        if(price.price > minimum && this.used == false)
        {
            return true;
        }
        else {return false;}
    }
    
    /**
    * @param price 	| Harga Room
    * @return potongan harga setelah voucher digunakan
    */
    public double apply(Price price)
    {
        this.used = true;
        if(this.type == Type.DISCOUNT)
        {
            if(this.cut > 100.0)
            {
                this.cut = 100.0;
            }
            return price.price - (price.price*(this.cut/100.0));
        }
        else 
        {
            if(this.cut >= price.price)
            {
                this.cut = price.price;
            }
            return price.price - this.cut;
        }
    }
    
    /**
     * Jenis voucher. Rebate dalam bentuk nilai dan discount dalam bentuk persen
     */
    public enum Type
    {
        REBATE, DISCOUNT
    }

}
