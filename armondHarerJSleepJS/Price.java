package armondHarerJSleepJS;


public class Price
{
    public double price;
    public double discount;
    
    public Price (double price)
    {
        this.price = price;
        this.discount = 0;
    }
    
    public Price (double price, double discount)
    {
        this.price = price;
        this.discount = discount;
    }
    
    /*public double price;
    public int discount;
    public double rebate;

    public Price(double price)
    {
        this.price = price;
        this.rebate = 0;
        this.discount = 0;
    }
    
    public Price(double price, int discount)
    {
        this.rebate = 0;
        this.price = price;
        this.discount = discount;
    }
    
    public Price(double price, double rebate)
    {
        this.discount = 0;
        this.price = price;
        this.rebate = rebate;
    }

    private double getdiscountedprice()
    {
        // put your code here
        if (this.discount >= 100)
        {
            this.discount = 100;
            return 0;
        }
        else 
        {
            return this.price * (this.discount / 100);
        }
    }
    
    private double getRebatedPrice()
    {
        if (this.rebate >= this.price)
        {
            this.rebate = this.price;
            return 0;
        }
        else
        {
            return this.price - this.rebate;
        }
    }*/
}