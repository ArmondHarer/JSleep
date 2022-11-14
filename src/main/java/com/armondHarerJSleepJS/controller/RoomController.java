package com.armondHarerJSleepJS.controller;

import com.armondHarerJSleepJS.*;
import com.armondHarerJSleepJS.dbjson.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
	
		@JsonAutowired(value = Room.class, filepath = "src/main/java/com/json/room.json")
	    public static JsonTable<Room> roomTable;
		
		@Override
		public JsonTable<Room> getJsonTable() {
			// TODO Auto-generated method stub
			return roomTable;
		}

	    @GetMapping("/{id}/renter")
	    List<Room> getRoomRenter
	    (
	            @PathVariable int id,
	            @RequestParam int page,
	            @RequestParam int pageSize
	    ){
	    	return Algorithm.paginate(getJsonTable(), page, pageSize, room -> room.accountId == id);
		}
	    
	    @PostMapping("/create")
	    public Room create(
				@RequestParam int accountId, 
				@RequestParam String name,
				@RequestParam int size,
				@RequestParam int price,
				@RequestParam Facility facility,
				@RequestParam City city,
				@RequestParam String address
				){
	    	if (Algorithm.<Account>exists(AccountController.accountTable, acc->acc.id==accountId && acc.renter!=null)) {
				Room newRoom = new Room(name, size, new Price(price), facility, city, address, accountId);
				roomTable.add(newRoom);	
				return newRoom;
			}
	    	return null;
		}
	    
}