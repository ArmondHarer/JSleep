package armondHarerJSleepJS;


/**
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JSleep
{
    public static void main(String args[])
    {
        System.out.println("Please wait, we are still adding features!");
    }
    
    public int getHotelId(){
        return 0;
    }
    
    public string getHotelName(){
        return "Hotel";
        //string error
    }
    
    public boolean isDiscount(){
        return true;
    }
    
    public float getDiscountedPercentage (int beforeDiscount, int afterDiscount) {
        int discountValue = (beforeDiscount - afterDiscount);
        int discountPercentage = (discountValue / beforeDiscount);
        if (discountValue < 0){
            discountPercentage = 0;
            //gak yakin ifnya bener ato nggak
        }
        return (float) discountPercentage;
    }
    
    public int getDiscountedPrice (int price, float discountPercentage){
        int discountedPrice = (price * (1 - discountPercentage));
        // ada error disini
    }
 }
