package armondHarerJSleepJS;
import java.util.HashMap;

/**
 * Write a description of class Serializable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Serializable implements Comparable<Serializable>
{
    // instance variables - replace the example below with your own
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    /**
     * Constructor for objects of class Serializable
     */
    private Serializable()
    {
    	Integer tempC = mapCounter.get(getClass());
    	if(tempC == null) {
    		tempC = 0;
    	}
    	else {
    		tempC++;
    	}
    	mapCounter.put(getClass(), tempC);
        this.id = tempC;
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id)
    {
        return mapCounter.put(clazz, id);
    }
    
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz)
    {
        return mapCounter.get(clazz);
    }
    
    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }
    
    public boolean equals(Serializable other)
    {
        return other.id == id;
    }

    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}

