package com.armondHarerJSleepJS;


import com.armondHarerJSleepJS.dbjson.Serializable;

/**
 * Class Renter untuk JSleep
 * @author Armond Harer
 */
public class Renter extends Serializable
{
    
    public String username;
    public String address;
    public String phonenumber;
    /**
     * Regex untuk nama dan nomor telepon renter
     * Untuk nama renter wajib memiliki huruf kapital di awal, hanya diperbolehkan huruf, angka dan underscore, dan 4 sampai 20 karakter
     * Untuk nomor telepon wajib berupa angka 9 sampai 12 digit
     */
    public static final String REGEX_NAME = "^[A-Z][A-Za-z0-9_]{5,21}$";
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
    
    /**
     * Mendeklarasi object Renter
     * @param username		| Nama dari renter
     * @param address		| Alamat renter
     * @param phonenumber	| Nomor Telepon renter
     */
    public Renter(String username, String address, String phonenumber)
    {
    	super();
        this.username = username;
        this.address = address;
        this.phonenumber = phonenumber;
    }
    
    /**
     * @return boolean konfirmasi apabila nama dan nomor telepon sesuai dengan regex
     */
    public boolean validate () {
    	return this.username.matches(REGEX_NAME) && this.phonenumber.matches(REGEX_PHONE);
    }
}
