package armondHarerJSleepJS;


public class Rating
{
    private long count;
    private long total;

    /**
     * Constructor for objects of class rating
     */
    public Rating()
    {
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating)
    {
        this.total += rating;
        this.count++;
    }
    
    public double getaverage(int count)
    {
        if (count <= 0)
        {
            System.out.println("No inputs available, please try again");
            return 0;
        }
        else
        {
            return this.total/this.count;
        }
    }
    
    public long getcount()
    {
        return this.count;
    }
    
    public long gettotal()
    {
        return this.total;
    }
    
    public String toString(){
        return "Rating Tally\nTotal: " + total + "\nCount: " + count;
    }
}
