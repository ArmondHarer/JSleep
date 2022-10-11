/**
 * 
 */
package armondHarerJSleepJS;
import java.util.Arrays;
import java.util.Iterator;

public class Algorithm {
	
	public static <T> int count(T[] array, T value) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, value);
    }

    public static <T> int count(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return count(iterable, pred);
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, pred);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        Iterator <T> iterator = iterable.iterator();
        return count(iterator, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int out = 0;
        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next())) {
                out++;
            }
        }
        return out;
    }

	
	public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        return exists(iterable, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> iterator = iterable.iterator();
    	return exists(iterator, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()) {
        	T curr = iterator.next();
            if(pred.predicate(curr)) {
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
        Predicate<T> pred = value::equals;
        return find(iterable, pred);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        return find(iterable.iterator(), pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()) {
            T object = iterator.next();
            if(pred.predicate(object)) {
                return object;
            }
        }
        return null;
    }
}
