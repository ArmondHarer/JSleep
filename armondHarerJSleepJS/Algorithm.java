/**
 * 
 */
package armondHarerJSleepJS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
	
	public static <T> int count(T[] array, T value) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, value);
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        Predicate<T> predi = value::equals;
        return count(iterable, predi);
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        Predicate<T> predi = value::equals;
        return count(iterator, predi);
    }

    public static <T> int count(T[] array, Predicate<T> predi) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, predi);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> predi) {
        Iterator <T> iterator = iterable.iterator();
        return count(iterator, predi);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> predi) {
    	
        int count = 0;
        while(iterator.hasNext()) {
            if(predi.predicate(iterator.next())) {
                count++;
            }
        }
        
        return count;
    }

	
	public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        return exists(iterable, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> predi = value::equals;
        return exists(iterator, predi);
    }

    public static <T> boolean exists(T[] array, Predicate<T> predi) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, predi);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> predi) {
        final Iterator<T> iterator = iterable.iterator();
    	return exists(iterator, predi);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> predi) {
    	
        while(iterator.hasNext()) {
        	T current = iterator.next();
            if(predi.predicate(current)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static <T> T find(T[] array, T value) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, value);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        Predicate<T> predi = value::equals;
        return find(iterable, predi);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        Predicate<T> predi = value::equals;
        return find(iterator, predi);
    }

    public static <T> T find(T[] array, Predicate<T> predi) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, predi);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> predi) {
        return find(iterable.iterator(), predi);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> predi) {
    	
        while(iterator.hasNext()) {
            T object = iterator.next();
            if(predi.predicate(object)) {
                return object;
            }
        }
        
        return null;
    }
    
    public static<T> List<T> collect(Iterable<T> iterator, T value){
    	
    	List<T> Collection = new ArrayList<T>();
    	
    	for (T each: iterator) {
            if(each.equals(value)) {
                Collection.add(each);
            }
        }
    	
        return Collection;
    }
    
    public static<T> List<T> collect(Iterator<T> iterator, T value){
    	
    	List<T> Collection = new ArrayList<T>();
    	
    	while (iterator.hasNext()) {
    		T each = iterator.next();
            if(each.equals(value)) {
                Collection.add(each);
            }
        }
    	
        return Collection;
    }
    
    public static<T> List<T> collect(Iterable<T> iterator, Predicate<T> predi) {
    	
        List<T> Collection = new ArrayList<T>();
        
        for (T each: iterator) {
            if(predi.predicate(each)) {
            	Collection.add(each);
            }
        }
        
        return Collection;
    }
    
    public static<T> List<T> collect(Iterator<T> iterator, Predicate<T> predi) {
    	
        List<T> Collection = new ArrayList<T>();
        
        while(iterator.hasNext()) {
            T each = iterator.next();
            if(predi.predicate(each)) {
            	Collection.add(each);
            }
        }
        
        return Collection;
    }
    
    public static<T> List<T> collect(T[] array, Predicate<T> predi) {
    	
        List<T> list = new ArrayList<T>();
        
        for (T each: array) {
            if(predi.predicate(each)) {
                list.add(each);
            }
        }
        
        return list;
    }
    
    public static<T> List<T> collect(T[] array, T value) {
    	
        List<T> list = new ArrayList<T>();
        
        for (T each: array) {
            if(each.equals(value)) {
                list.add(each);
            }
        }
        
        return list;
    }
    
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> predi){
        //return Arrays.stream(array).filter(pred::predicate).skip(pageSize*page).limit(pageSize).collect(Collectors.toList());
    	
    	List<T> Collection = new ArrayList<T>();
    	int counter = 0, counterSize = 0;
    	int size = page * pageSize;
    	
    	for(T each: Collection) {
    		if (counter < size && predi.predicate(each))
    		{
    			counter++;
    			continue;
    		}
    		else if (counterSize < pageSize && predi.predicate(each))
    		{
    			Collection.add (each);
    			break;
    		}
    	}
    	return Collection;
    }
    
    public static <T> List<T> paginate(Iterable<T> iterator, int page, int pageSize, Predicate<T> predi){
        List<T> Collection = new ArrayList<T>();
        int counter = 0, counterSize = 0;
        int size = pageSize * page;
        for (T each : iterator){
            if (counter < size && predi.predicate(each)){
                counter++;
                continue;
            }
            if (counterSize < pageSize && predi.predicate(each)){
            	Collection.add(each);
                counterSize++;
            }else{
                break;
            }
        }
        return Collection;
    }
    
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        int i;
        int counter = 0;
        int size = page * pageSize;
        List<T> pages = new ArrayList<>(pageSize);

        List<T> array = new ArrayList<T>();

        iterator.forEachRemaining(array::add);

        for (i = 0; i < array.size() && counter < size; i++) {
            if (pred.predicate(array.get(i))) {
            	counter++;
            }
        }
        for (i = 0; i < array.size() && pages.size() < pageSize; i++) {
            if (pred.predicate(array.get(i))) {
            	pages.add(array.get(i));
            }
        }
        return pages;
    }
}
