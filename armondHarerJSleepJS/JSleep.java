package armondHarerJSleepJS;
import java.sql.Date;

public class JSleep
{
    public static void main (String[] args) {
    Room RoomA = JSleep.createRoom();
    Room RoomB = JSleep.createRoom();
    System.out.println("Membuat booking dari tanggal 15 hingga 18");
    Date start = Date.valueOf("2022-8-15");
    Date end = Date.valueOf("2022-8-20");
    System.out.println(Payment.makeBooking(start, end,RoomA));
    System.out.println("Membuat booking dari tanggal 15 hingga 18");
    Date start2 = Date.valueOf("2022-8-18");
    Date end2 = Date.valueOf("2022-8-20");
    System.out.println(Payment.makeBooking(start2, end2,RoomA));
    System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
    Date start3 = Date.valueOf("2022-8-18");
    Date end3 = Date.valueOf("2022-8-20");
    System.out.println(Payment.makeBooking(start3, end3,RoomB));
    }
    
    public static Room createRoom()
    {
        Price price = new Price (200000, 1000.00);
        Room room = new Room (1, "Hotel", 30, price, Facility.AC, City.BALI, "Bali Street");
        return room;
    }

    /*
    public static void main (String[] args) {
        Payment testPayment = new Payment(2, 2, 2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        for(int i=0;i < unfilteredArray.length;i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
            }
        System.out.println("Price List");
        for(int i=0;i < unfilteredArray.length;i++){
        System.out.println(unfilteredArray[i].price);
        }
        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000,true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000,false));
    }
    
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
    
    public static void main(String[] args)
    {
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.facility);
        System.out.println(test.price.price);
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