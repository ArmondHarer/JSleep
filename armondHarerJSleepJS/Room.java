package armondHarerJSleepJS;


/*
public class Room
{
    // instance variables - replace the example below with your own
    public int size; 
    public String name;
    public Facility facility;
    public Price price;
    
    public Room (String name, int size, Facility facility, Price price)
    {
        this.price = price;
        this.name = name;
        this.size = size;
        this.facility = facility;
    }
}
*/

public class Room extends Serializable
{
    public int Size;
    public String name;
    public Price price;
    public Facility facility;
    public String address;
    public BedType bedType;
    public City city;
    
    public Room (int id, int Size, String name, Price price, Facility facility, City city, String address)
    {
        super(id);
        this.Size = Size;
        this.name = name;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }
    
    public String toString(){
        return "Room Information : \nId: " + super.id + "\nName: " + name + "\nSize: " + Size + "m^2\nPrice: $" + price + "\nFacility: " + facility + "\nCity: " + city + "\nAddress: " + address + "\nBed Type: " + bedType;
    }
}
