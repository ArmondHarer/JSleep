package com.armondHarerJSleepJS.controller;

import org.springframework.web.bind.annotation.*;

import com.armondHarerJSleepJS.*;
import com.armondHarerJSleepJS.dbjson.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.*;

import static com.armondHarerJSleepJS.controller.AccountController.accountTable;
import static com.armondHarerJSleepJS.controller.RoomController.roomTable;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	 @JsonAutowired(filepath = "ssrc/main/java/com/json/Payment.json", value = Payment.class)
	  public static JsonTable<Payment> paymentTable;
	 
	 public JsonTable<Payment> getJsonTable() {
	        return paymentTable;
	  }
	 
	 @PostMapping("/create")
	  public Payment create(@RequestParam int buyerId,
	                   @RequestParam int renterId,
	                   @RequestParam int roomId,
	                   @RequestParam String from,
	                   @RequestParam String to) { 
		 	Account findAccount = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId);
	        Room findRoom = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == roomId);
	        double roomPrice = findRoom.price.price;

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date fromDate;
	        Date toDate;
	        try {
	            fromDate = sdf.parse(from);
	            toDate = sdf.parse(to);
	        } catch (ParseException e) {
	            throw new RuntimeException(e);
	        }

	        if (findAccount.balance >= roomPrice && Payment.availability(fromDate, toDate, findRoom)) {
	            Payment newPayment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
	            findAccount.balance -= roomPrice;
	            newPayment.status = Invoice.PaymentStatus.WAITING;
	            Payment.makeBooking(fromDate, toDate, findRoom);
	            paymentTable.add(newPayment);
	            return newPayment;
	        }
	        return null;
	 }
	 
	 @PostMapping("/{id}/accept")
	 boolean accept(@PathVariable int id) {
		 for(Payment payment : paymentTable) {
	            if(id == payment.id) {
	            	return true;
	            }
	        }
	        return false;
	 }
	 
	 
	 @PostMapping("/{id}/cancel")
	 boolean cancel(@PathVariable int id) {
		 return false;
	 }
	 
}
