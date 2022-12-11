package com.armondHarerJSleepJS;

/**
 * Class untuk rating dalam JSleep
 * @author Armond Harer
 */
public class Rating
{
    private long count;
    private long total;

    /**
     * Konfigurasi awal rating ruangan 
     */
    public Rating()
    {
        this.total = 0;
        this.count = 0;
    }

    /**
     * @param rating | rating dari pelanggan ditambah ke total
     */
    public void insert(int rating)
    {
        this.total += rating;
        this.count++;
    }
    
    /**
     * 
     * @param count | jumlah rating
     * @return rating rata-rata dari ruangan 
     */
    public double getaverage(int count)
    {
        if (count <= 0)
        {
            System.out.println("No inputs available, please try again");
            return 0;
        }
        else
        {
            return (double)this.total/(double)this.count;
        }
    }
    
    /**
     * @return getter untuk jumlah rating
     */
    public long getcount()
    {
        return this.count;
    }
    
    /**
     * @return getter untuk rating total
     */
    public long gettotal()
    {
        return this.total;
    }
    
    /**
     * @return informasi rating dalam bentuk string
     */
    public String toString(){
        return "Rating Tally\nTotal: " + total + "\nCount: " + count;
    }
}
