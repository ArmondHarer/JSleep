package armondHarerJSleepJS;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class JSleep
{
	 public static void main(String[] args)
	    {	
	        Renter testRegex1 = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
	        Renter testRegexFail1 = new Renter("netlab", "081", "Jalan");
	        Account testRegex2 = new Account("Netlab", "supriyono@ui.ac.id", "Supr1y0n0");
	        Account testRegexFail2 = new Account("Netlab", "email.salah@gmai1.com", "Armond");
	        System.out.println(testRegex1.validate());
	        System.out.println(testRegexFail1.validate());
	        System.out.println(testRegex2.validate());
	        System.out.println(testRegexFail2.validate());
	        
	        String filepath = "C:\\Users\\armon\\File Coolyeah Armond\\OOP\\Porgram Armond\\json\\Account.json";
            Gson gson = new Gson();
	        try{
	        	JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
	        	tableAccount.add(new Account("name","email","password"));
	            tableAccount.writeJson();
	        	
	        }
	        catch(Throwable t){
	            t.printStackTrace();
	        }
	        
	        for(int i=0;i < 10; i++) {
	        	ThreadingObject thread = new ThreadingObject("Thread " + i);
	        }
	    }
	 
	public static Room createRoom()
    {
        Price price = new Price (200000, 1000.00);
        Room room = new Room ("Armond", 30, price, Facility.AC, City.BALI, "Bali Street",2106634710);
        return room;
    }
	
	public static List<Room> filterByCity(List<Room> rooms, String city, int page, int pageSize){
        List<Room> filteredRooms = new ArrayList<>();
        int start = page * pageSize;
        for(int i = 0; i < rooms.size(); i++){
            Room room = rooms.get(i);
            if(room.city.name().toLowerCase().contains(city.toLowerCase())){
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }
	
	public static List<Room> filterByPrice(List<Room> rooms, double minPrice, double maxPrice){
        List<Room> filteredRooms = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++){
            Room room = rooms.get(i);
            if(room.price.price >= minPrice && room.price.price <= maxPrice){
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }
	
	public static List<Room> filterByAccountId(List<Room> rooms, int accountId, int page, int pageSize){
        List<Room> filteredRooms = new ArrayList<>();
        int start = page * pageSize;
        for(int i = start; i < rooms.size(); i++){
            Room room = rooms.get(i);
            if(room.accountId == accountId){
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }
}

/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

public class JSleep
{
	class Country{
		public String name;
		public int population;
		public List<String> listOfStates;
	}
	
	public static void main (String[] args)
	{
		String filepath= "C:\\Users\\armon\\File Coolyeah Armond\\OOP\\Porgram Armond\\armondHarerJSleepJS\\city.json";
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			Country input = gson.fromJson(br, Country.class);
			System.out.println("name: " + input.name);
			System.out.println("population: " + input.population);
			System.out.println("states :");
			input.listOfStates.forEach(state -> System.out.println(state));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
*/


/*import java.sql.Date;

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
        Room room = new Room ("Hotel", 30, price, Facility.AC, City.BALI, "Bali Street");
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