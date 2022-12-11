package com.armondHarerJSleepJS;

/**
 * Class untuk harga pembayaran dalam JSleep
 * @author Armond Harer
 */
public class Price
{
    public double price;
    public double discount;
    
    /**
     * Constructor tanpa diskon
     * @param price | harga
     */
    public Price (double price)
    {
        this.price = price;
        this.discount = 0;
    }
    
    /**
     * Constructor dengan diskon
     * @param price 	| harga
     * @param discount	| diskon
     */
    public Price (double price, double discount)
    {
        this.price = price;
        this.discount = discount;
    }
    
    /**
     * @return getter untuk harga
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param price | setter untuk price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return getter untuk diskon
     */
    public double getDiscount() {
        return discount;
    }
    /**
     * @param discount | setter untuk discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    /**
     * @return informasi harga dan diskon dalam string
     */
    public String toString()
    {
        return "Pricing Information : \nPrice : " + price + "\nDiscount Percentage : " + discount;
    }
}