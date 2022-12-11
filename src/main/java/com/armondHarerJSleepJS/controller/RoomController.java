package com.armondHarerJSleepJS.controller;

import com.armondHarerJSleepJS.*;
import com.armondHarerJSleepJS.dbjson.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * Controller yang akan menentukan interaksi dengan room di aplikasi
 * @author Armond Harer
 */
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
	
		@JsonAutowired(value = Room.class, filepath = "src/main/java/com/json/room.json")
	    public static JsonTable<Room> roomTable;
		
		/**
		 * Getter untuk JsonTable
		 */
		@Override
		public JsonTable<Room> getJsonTable() {
			return roomTable;
		}

		/**
		 * Mencari renter dari sebuah room
		 * @param id		| ID dari room
		 * @param page		| Page mana yang akan ditampilkan
		 * @param pageSize	| Jumlah room dalam page
		 * @return hasil paginasi room berdasarkan ID
		 */
	    @GetMapping("/{id}/renter")
	    List<Room> getRoomRenter
	    (
	            @PathVariable int id,
	            @RequestParam int page,
	            @RequestParam int pageSize
	    ){
	    	return Algorithm.paginate(getJsonTable(), page, pageSize, room -> room.accountId == id);
		}
	    
	    /**
	     * Membuat rooom baru
	     * @param accountId	| ID account yang membuat room
	     * @param name		| Nama dari room
	     * @param size		| Ukuran room
	     * @param price		| Harga room (per malam)
	     * @param facility	| Fasilitas yang ada dalam room (dalam bentuk arraylist)
	     * @param city		| Kota dimana room terletak
	     * @param address	| Alamat room
	     * @return room baru
	     */
	    @PostMapping("/create")
	    public Room create(
				@RequestParam int accountId, 
				@RequestParam String name,
				@RequestParam int size,
				@RequestParam double price,
				@RequestParam ArrayList<Facility> facility,
				@RequestParam City city,
				@RequestParam BedType bedtype,
				@RequestParam String address
				){
	    	//Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
	        //if(account == null){
	        //    return null;
	        //}
	        Room newRoom = new Room(name, size, new Price(price), facility, city, bedtype, address, accountId);
	        try {
	        	roomTable.add(newRoom);
	        	roomTable.writeJson();
              }catch(Throwable t) {
              	t.printStackTrace();
              }
	        return newRoom;
		}
	    
	    /**
	     * Mengambil semua room yang ada
	     * @param page		| Satu page dari arraylist room
	     * @param pageSize	| Jumlah room dalam page
	     * @return List yang sudah di-paginate
	     */
	    @GetMapping("/getAllRoom")
	    List<Room> getAllRoom(@RequestParam int page, @RequestParam int pageSize){
	    	return Algorithm.<Room>paginate(roomTable,page,pageSize, pred->(true));
	    }
}