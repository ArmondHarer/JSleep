package armondHarerJSleepJS;


/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Validate{
    public Validate(){}
    
public static ArrayList filter (Price[] list, int value, boolean less){ 
    ArrayList<Double> result = new ArrayList<Double>();
    if(less){for(Price i : list){ 
        if(i.price <= value){
             result.add(i.price);   
            }             
        }             
    }   

    else{for(Price i : list){                 
        if(i.price > value){                     
            result.add(i.price);                 
            }             
        }         
    }         
    return result;     
} 
}
