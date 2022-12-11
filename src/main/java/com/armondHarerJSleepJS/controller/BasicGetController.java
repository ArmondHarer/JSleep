package com.armondHarerJSleepJS.controller;

import com.armondHarerJSleepJS.dbjson.*;
import com.armondHarerJSleepJS.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
	public abstract JsonTable<T> getJsonTable();
	
	/**
	 * Mendapatkan page tertentu dari sebuah list
	 * @param page		| Halaman ke-sekian
	 * @param pageSize	| Jumlah elemen dalam halaman
	 * @return page yang telah di-paginate
	 */
	@GetMapping(value ="/page")
	public default List<T> getPage(@RequestParam int page, 
								   @RequestParam int pageSize) {
		return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred-> true);
	}
	
	/**
	 * Mendapatkan sesuatu berdasarkan IDnya
	 * @param id	| ID yang akan digunakan
	 * @return Object yang ingin di-get
	 */
	@GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        for(T object : getJsonTable()) {
        	if(object.id == id) {
        		return object;
            	}
        	}
        
        return null;
    }
	
}
