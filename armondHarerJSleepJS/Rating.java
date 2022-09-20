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
        total += rating;
        count++;
    }
    
    public double getaverage(int count)
    {
        double average;
        if (count < 0)
        {
            System.out.println("No inputs available, please try again");
            average = 0;
        }
        else
        {
            average = total / count;
        }
        return average;
    }
    
    public long getcount()
    {
        return count;
    }
    
    public long gettotal()
    {
        return total;
    }
}