package com.armondHarerJSleepJS;

import java.util.*;

/**
 * Class untuk membandingkan harga
 * @author Armond Harer
 */
public class Validate{
    public Validate(){}
    
    /**
     * mengfilter list Price
     * @param list		| List dari harga-harga room
     * @param value		| Nilai yang akan dibandingkan
     * @param less		| Menentukan apabila price dalam list kurang atau tidak 
     * @return
     */
    public static ArrayList<Double> filter (Price[] list, int value, boolean less){ 
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
