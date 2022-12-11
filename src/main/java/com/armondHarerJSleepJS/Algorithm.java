package com.armondHarerJSleepJS;
/**
 * 
 */
import java.util.*;


/**
 * Algorithm untuk menghitung, mencari dan mengolah data
 * @author Armond Harer
 */
public class Algorithm {
	
	/**
     * call Algorithm
     */
	private Algorithm() {}
	
	/**
	 * Menghitung value dalam array
	 * @param <T>		| generic
	 * @param array		| array sumber
	 * @param value		| nilai yang ingin dihitung
	 * @return jumlah value dalam array
	 */
	public static <T> int count(T[] array, T value) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, value);
    }

	/**
	 * Menghitung value dalam iterable
	 * @param <T>		| generic
	 * @param iterable	| iterable sumber
	 * @param value		| nilai yang ingin dihitung
	 * @return jumlah value dalam iterable
	 */
    public static <T> int count(Iterable<T> iterable, T value) {
    	Predicate<T> predi = value::equals;
        return count(iterable, predi);
    }

    /**
     * Menghitung nilai dalam iterator
     * @param <T>		| generic
     * @param iterator	| Iterable sumber
     * @param value		| nilai yang ingin dihitung
     * @return jumlah value dalam iterator
     */
    public static <T> int count(Iterator<T> iterator, T value) {
    	Predicate<T> predi = value::equals;
        return count(iterator, predi);
    }

    /**
     * Menghitung jumlah nilai dalam array
     * @param <T>		| generic
     * @param array		| array sumber
     * @param predi		| ekspresi boolean dalam lambda
     * @return jumlah value dalam array
     */
    public static <T> int count(T[] array, Predicate<T> predi) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, predi);
    }

    /**
     * Menghitung jumlah nilai dalam iterable
     * @param <T>		| generic
     * @param iterable	| iterable sumber
     * @param predi		| ekspresi boolean dalam lambda
     * @return jumlah nilai dalam iterable
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> predi) {
        Iterator <T> iterator = iterable.iterator();
        return count(iterator, predi);
    }

    /**
     * Menghitung jumlah nilai dalam iterable
     * @param <T>		| generic
     * @param iterator	| Iterator sumber
     * @param predi		| ekspresi boolean dalam lambda
     * @return jumlah nilai dalam iterable
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> predi) {
    	
        int count = 0;
        while(iterator.hasNext()) {
            if(predi.predicate(iterator.next())) {
                count++;
            }
        }
        return count;
    }

	/**
	 * Mencari apabila nilai ada dalam array
	 * @param <T>		| generic
	 * @param array		| array sumber
	 * @param value		| nilai yang ingin dicari
	 * @return true apabila terdapat nilai, false apabila tidak
	 */
	public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, value);
    }

	/**
	 * Mencari apabila nilai ada dalam iterable
	 * @param <T>		| generic
	 * @param iterable	| iterable sumber
	 * @param value		| nilai yang ingin dicari
	 * @return true apabila terdapat nilai, false apabila tidak
	 */
    public static <T> boolean exists(Iterable<T> iterable, T value) {
        return exists(iterable, value);
    }

    /**
     * Mencari apabila nilai berada dalam iterable
     * @param <T>		| generic
     * @param iterator	| iterator sumber
     * @param value		| nilai yang ingin dicari
     * @return true apabila terdapat nilai, false apabila tidak
     */
    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> predi = value::equals;
        return exists(iterator, predi);
    }

    /**
     * Mencari apabila nilai ada dalam array
     * @param <T>		| generic
     * @param array		| array sumber
     * @param predi		| ekspresi boolean dalam bentuk lambda
     * @return true apabila terdapat nilai, false apabila tidak
     */
    public static <T> boolean exists(T[] array, Predicate<T> predi) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, predi);
    }

    /**
     * Mencari apabila nilai ada dalam iterable
     * @param <T>		| generic
     * @param iterable	| iterable sumber
     * @param predi		| ekspresi boolean dalam bentuk lambda
     * @return true apabila terdapat nilai, false apabila tidak
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> predi) {
        final Iterator<T> iterator = iterable.iterator();
    	return exists(iterator, predi);
    }

    /**
     * Mencari apabila nilai ada dalam iterator
     * @param <T>		| generic
     * @param iterator	| iterator sumber
     * @param predi		| ekspresi boolean dalam bentuk lambda
     * @return true apabila terdapat nilai, false apabila tidak
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> predi) {
    	
        while(iterator.hasNext()) {
        	T current = iterator.next();
            if(predi.predicate(current)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Mencari value dalam array
     * @param <T>		| generic
     * @param array		| array yang ingin dicari
     * @param value		| nilai yang ingin dicari
     * @return value yang ditemukan dalam array
     */
    public static <T> T find(T[] array, T value) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, value);
    }

    /**
     * Mencari value dalam iterable
     * @param <T>		| generic
     * @param iterable	| iterable sumber
     * @param value		| nilai yang ingin dicari
     * @return value yang ditemukan dalam iterable
     */
    public static <T> T find(Iterable<T> iterable, T value) {
        Predicate<T> predi = value::equals;
        return find(iterable, predi);
    }

    /**
     * Mencari value dalam iterator
     * @param <T>		| generic
     * @param iterator	| iterator sumber
     * @param value		| nilai yang ingin dicari
     * @return value yang ditemukan dalam iterator
     */
    public static <T> T find(Iterator<T> iterator, T value) {
        Predicate<T> predi = value::equals;
        return find(iterator, predi);
    }

    /**
     * Mencari value dalam array
     * @param <T>		| generic
     * @param array		| array yang ingin dicari
     * @param predi		| ekspresi boolean dalam bentuk lambda
     * @return value yang ditemukan dalam array
     */
    public static <T> T find(T[] array, Predicate<T> predi) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, predi);
    }

    /**
     * Mencari value dalam iterable
     * @param <T>		| generic
     * @param iterable	| iterable sumber
     * @param predi		| ekspresi boolean dalam bentuk lambda
     * @return value yang ditemukan dalam array
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> predi) {
        return find(iterable.iterator(), predi);
    }

    /**
     * Mencari value dalam iterator
     * @param <T>		| generic
     * @param iterator	| iterator sumber
     * @param predi		| ekspresi boolean dalam bentuk lambda
     * @return value yang ditemukan dalam array
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> predi) {
    	
        while(iterator.hasNext()) {
            T object = iterator.next();
            if(predi.predicate(object)) {
                return object;
            }
        }
        
        return null;
    }
    
    /**
     * Filtering iterable
     * @param <T>		| generic
     * @param iterator	| iterable darj sumber
     * @param value		| nilai yang ingin dicari 
     * @return list yang telah difilter
     */
    public static<T> List<T> collect(Iterable<T> iterator, T value){
    	
    	List<T> Collection = new ArrayList<T>();
    	
    	for (T each: iterator) {
            if(each.equals(value)) {
                Collection.add(each);
            }
        }
    	
        return Collection;
    }
    
    /**
     * Filtering iterator
     * @param <T>		| generic
     * @param iterator	| iterator darj sumber
     * @param value		| nilai yang ingin dicari 
     * @return list yang telah difilter
     */
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
    
    /**
     * Filtering iterable
     * @param <T>		| generic
     * @param iterator	| iterable darj sumber
     * @param predi		| ekspresi boolean yang berbentuk lambda 
     * @return list yang telah difilter
     */
    public static<T> List<T> collect(Iterable<T> iterator, Predicate<T> predi) {
    	
        List<T> Collection = new ArrayList<T>();
        
        for (T each: iterator) {
            if(predi.predicate(each)) {
            	Collection.add(each);
            }
        }
        
        return Collection;
    }
    
    /**
     * Filtering iterator
     * @param <T>		| generic
     * @param iterator	| iterator darj sumber
     * @param predi		| ekspresi boolean yang berbentuk lambda 
     * @return list yang telah difilter
     */
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
    
    /**
     * Filtering array
     * @param <T>		| generic
     * @param array		| array yang ingin difilter
     * @param predi		| ekspresi boolean yang berbentuk lambda 
     * @return list yang telah difilter
     */
    public static<T> List<T> collect(T[] array, Predicate<T> predi) {
    	
        List<T> list = new ArrayList<T>();
        
        for (T each: array) {
            if(predi.predicate(each)) {
                list.add(each);
            }
        }
        
        return list;
    }
    
    /**
     * Filtering sebuah array
     * @param <T>		| generic
     * @param array		| array yang ingin difilter
     * @param value		| nilai yang ingin dicari
     * @return list yang telah difilter
     */
    public static<T> List<T> collect(T[] array, T value) {
    	
        List<T> list = new ArrayList<T>();
        
        for (T each: array) {
            if(each.equals(value)) {
                list.add(each);
            }
        }
        
        return list;
    }
    
    /**
     * Filter dan paginate list dari array
     * @param <T>		| generic
     * @param array		| array yang ingin di-paginate
     * @param page		| halaman ke-sekian
     * @param pageSize	| jumlah elemen dalam halaman
     * @param pred		| ekspresi boolean dalam bentuk lambda
     * @return list yang telah di-paginate
     */
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
    
    /**
     * Filter dan paginate list dari iterable
     * @param <T>		| generic
     * @param iterator	| iterable sumber
     * @param page		| halaman ke-sekian
     * @param pageSize	| jumlah elemen dalam halaman
     * @param pred		| ekspresi boolean dalam bentuk lambda
     * @return list yang telah di-paginate
     */
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
    
    /**
     * Filter dan paginate list dari iterator
     * @param <T>		| generic
     * @param iterator	| iterator sumber
     * @param page		| halaman ke-sekian
     * @param pageSize	| jumlah elemen dalam halaman
     * @param pred		| ekspresi boolean dalam bentuk lambda
     * @return list yang telah di-paginate
     */
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
