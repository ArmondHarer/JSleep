package com.armondHarerJSleepJS.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.armondHarerJSleepJS.*;
import com.armondHarerJSleepJS.dbjson.*;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
	@JsonAutowired(filepath = "src/main/java/com/json/Voucher.json", value = Voucher.class)
    public static JsonTable<Voucher> voucherTable;
	
	@Override
	public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }
	
	@GetMapping(value = "/{id}/isUsed")
	boolean isUsed(@PathVariable int id) {
		 		for(Voucher voucher : voucherTable) {
		 						if(id == voucher.code) {
		 							return voucher.isUsed();
		 							}
		 						}
		 		return false;
	    }
	
	@GetMapping(value ="/{id}/canApply")
    boolean canApply(@PathVariable int id,
                     @RequestParam double price) {

        for(Voucher voucher : voucherTable) {
            if(id == voucher.code) {
                return true;
            }
        }
        return false;

    }
	
	@GetMapping(value = "/getAvailable")
    List<Voucher> getAvailable(@RequestParam int page,
                              @RequestParam int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());
    }

}
