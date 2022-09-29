package armondHarerJSleepJS;


public class Voucher extends Serializable
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    
    public Voucher (int id, String name, int code, Type type, double minimum, double cut)
    {
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = used;
    }
    
    public boolean isUsed()
    {
        return this.used;
    }
    
    public boolean canApply(Price price)
    {
        if(price.price > minimum && this.used == false)
        {
            return true;
        }
        else 
        {
            return false; 
        }
    }
    
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
}
