package com.armondHarerJSleepJS.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import com.armondHarerJSleepJS.*;
import com.armondHarerJSleepJS.dbjson.*;

/**
 * Controller yang berhubungan dengan voucher di front end
 * @author Armond Harer
 */
@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
	@JsonAutowired(filepath = "src/main/java/com/json/Voucher.json", value = Voucher.class)
    public static JsonTable<Voucher> voucherTable;
	
	/**
	 * Getter untuk Json Table
	 */
	@Override
	public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }
	
	/**
	 * Menentukan apabila voucher telah digunakan atau belum
	 * @param id | ID dari voucher
	 * @return boolean yang menentukan apabila voucher digunakan atau belum
	 */
	@GetMapping(value = "/{id}/isUsed")
	boolean isUsed(@PathVariable int id) {
		 		for(Voucher voucher : voucherTable) {
		 						if(id == voucher.code) {
		 							return voucher.isUsed();
		 							}
		 						}
		 		return false;
	    }
	
	/**
	 * Menentukan apabila voucher dapat digunakan
	 * @param id	| ID dari voucher
	 * @param price	| Harga dari ruangan yang akan disewa
	 * @return
	 */
	@GetMapping(value ="/{id}/canApply")
    boolean canApply(@PathVariable int id,
                     @RequestParam double price) {

        for(Voucher voucher : voucherTable) {
            if(id == voucher.code) {
                return voucher.canApply(new Price(price));
            }
        }
        return false;

    }
	
	/**
	 * Meng-paginate voucher-voucher yang ada
	 * @param page		| Halaman
	 * @param pageSize	| Jumlah elemen per halaman
	 * @return list voucher
	 */
	@GetMapping(value = "/getAvailable")
    List<Voucher> getAvailable(@RequestParam int page,
                              @RequestParam int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());
    }

}
