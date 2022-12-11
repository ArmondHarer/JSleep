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
public class PaymentController implements BasicGetController<Payment>{
	
	 @JsonAutowired(filepath = "src/main/java/com/json/Payment.json", value = Payment.class)
	  public static JsonTable<Payment> paymentTable;
	 
	 @Override
	 public JsonTable<Payment> getJsonTable() {
	        return paymentTable;
	  }
	 
	 /**
	  * Membuat payment baru
	  * @param buyerId		| ID akun pembeli
	  * @param renterId		| ID renter akun
	  * @param roomId		| ID ruangan
	  * @param from			| ruangan dibeli dari-
	  * @param to			| ruangan dibeli sampai-
	  * @return payment ruangan baru
	  * @throws ParseException
	  */
	 @PostMapping("/create")
	  public Payment create(@RequestParam int buyerId,
	                   @RequestParam int renterId,
	                   @RequestParam int roomId,
	                   @RequestParam String from,
	                   @RequestParam String to) throws ParseException { 
		 	System.out.println("Test!");
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
	            if(Payment.makeBooking(fromDate, toDate, findRoom)){
	            paymentTable.add(newPayment);
	            return newPayment;
	            }
	        }
	        return null;
	 }
	 
	 /**
	  * Mengkonfirmasi pembayaran
	  * @param id	| ID pembayaran
	  * @return boolean konfirmasi pembayaran
	  */
	 @PostMapping("/{id}/accept")
	 public boolean accept(@PathVariable int id) {
		 for(Payment payment : paymentTable) {
	            if(id == payment.id) {
	                if(payment == null ) {return false;}
	                if(payment.status == Invoice.PaymentStatus.WAITING) {return false;}
	                payment.status = Invoice.PaymentStatus.SUCCESS;
	                return true;
	            }
	        }
		 return false;
	 }
	 
	 
	 /**
	  * Mengcancel pembayaran dan refund ke balance akun
	  * @param id	| ID pembayaran
	  * @return boolean cancel pembayaran
	  */
	 @PostMapping("/{id}/cancel")
	 public boolean cancel(@PathVariable int id) {
		 for(Payment payment : paymentTable) {
	            if(id == payment.id) {
	                if(payment == null ) {return false;}
	                if(payment.status == Invoice.PaymentStatus.WAITING) {return false;}
	                Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
	                Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.getRoomId());
	                payment.status = Invoice.PaymentStatus.FAILED;
	                buyer.balance += room.price.price;
	                return true;
	            }
	        }
		 return false;
	 }
	 
	 /**
	  * Submit payment
	  * @param id
	  * @return false
	  */
	 @PostMapping("/{id}/submit")
	    public boolean submit(@RequestParam int id){
	        return false;
	    }
	 
	 /**
	  * Get Payment by ID
	  * @param id 	| payment ID
	  * @return payment
	  */
	 @Override
	    public Payment getById(int id) {
	        return Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
	    }

	 /**
	  * Get page of payment
	  * @param page			| halaman ke-berapa
	  * @param pageSize		| jumlah elemen dalam satu halaman
	  * @return list payment yang di-paginate
	  */
	    @Override
	    public List<Payment> getPage(int page, int pageSize) {
	        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
	    }

}
