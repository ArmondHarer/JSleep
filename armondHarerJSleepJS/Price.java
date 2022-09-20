package armondHarerJSleepJS;


public class Price
{
    public double price;
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

    public double getdiscountedprice()
    {
        // put your code here
        if (discount > 100.00)
        {
            price = 0;
            return price;
        }
        else 
        {
            price = price * 100 / discount;
            return price;
        }
    }
    
    public double getRebatedPrice()
    {
        if (rebate > price)
        {
            rebate = price;
        }
        
        price = price - rebate;
        return price;
    }
}