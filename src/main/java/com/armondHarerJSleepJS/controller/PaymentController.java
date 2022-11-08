package com.armondHarerJSleepJS.controller;

import org.springframework.web.bind.annotation.*;

import com.armondHarerJSleepJS.Account;
import com.armondHarerJSleepJS.Payment;
import com.armondHarerJSleepJS.dbjson.*;


public class PaymentController {
	
	 @JsonAutowired(filepath = "json/Payment.json", value = Payment.class)
	  public static JsonTable<Payment> paymentTable;
	 
	 @PostMapping("/create")
	    Payment create(@RequestParam int buyerId,
	                   @RequestParam int renterId,
	                   @RequestParam int roomId,
	                   @RequestParam String from,
	                   @RequestParam String to) { 
		 	return null;
		 }
	 
	 @PostMapping("/{id}/accept")
	 boolean accept(@PathVariable int id) {
		 return false;
	 }
	 
	 @PostMapping("/{id}/cancel")
	 boolean cancel(@PathVariable int id) {
		 return false;
	 }
	 
	 public JsonTable<Payment> getJsonTable() {
	        return paymentTable;
	  }
}
