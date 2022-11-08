package com.armondHarerJSleepJS.controller;

import com.armondHarerJSleepJS.dbjson.Serializable;
import com.armondHarerJSleepJS.Account;
import com.armondHarerJSleepJS.Algorithm;
import com.armondHarerJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
	public abstract JsonTable<T> getJsonTable();
	
	@GetMapping(value ="/page")
	public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
		return Algorithm.paginate(getJsonTable(), page, pageSize, pred-> true);
	}
	
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
