package armondHarerJSleepJS;

public class JSleep
{
    public static void main(String[] args) {
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, 5, "Presidential Suite", testPrice,
        Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
    }
    
    /*  public static void main(String[] args)
    {
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.facility);
        System.out.println(test.price.price);
    }
    
    public static Room createRoom()
    {
        // put your code here
        Price price = new Price (200000, 1000.00);
        Room room = new Room ("Economy", 50, Facility.Balcony, price);
        return room;
    }
    */
}

/*
 *
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 *
public class JSleep
{
    public static void main(String args[])
    {
        System.out.println("Please wait, we are still adding features!");
    }
    
    public int getHotelId(){
        return 0;
    }
    
    public String getHotelName(){
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
        int discountedPrice = ((1 - discountPercentage) * price);
        // ada error disini
    }
 }
*/