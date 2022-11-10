package com.armondHarerJSleepJS.controller;

import com.armondHarerJSleepJS.Account;
import com.armondHarerJSleepJS.Renter;
import com.armondHarerJSleepJS.dbjson.*;
import com.armondHarerJSleepJS.Algorithm;

import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;
import java.util.Objects;
import java.io.IOException;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	@JsonAutowired(value = Account.class, filepath ="src/json.account")
    public static JsonTable<Account> accountTable;
	public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\\\\\\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\\\\\d)[a-zA-Z\\\\\\\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
    
    @PostMapping("account/login")
    Account login(@RequestParam String email, @RequestParam String password){
        return Algorithm.<Account>find(accountTable, acc-> acc.email==email & acc.password == password);
    }
    
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
    	 /*if(name.isBlank() || !REGEX_PATTERN_EMAIL.matcher(email).matches() || !REGEX_PATTERN_PASSWORD.matcher(password).matches()) {
             return null;
         }
    	 
         for(Account account : accountTable) {
             if(Objects.equals(account.email, email)) {
                 return null;
             }
         }*/
         Account NewACC = new Account(name, email, password);
         accountTable.add(NewACC);
         return NewACC;
    }
    
    @PostMapping("account/{id}/registerRenter")
    Renter registerRenter
            (
                    @PathVariable int id,
                    @RequestParam String username,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {
    	for(Account account : accountTable) {
            if(account.id == id) {
                Renter renter = new Renter(username, address, phoneNumber);
                return renter;
            	}
    		}
    	return null;
    }
    
    boolean topUp(@PathVariable int id,
            @RequestParam double balance) {

    		for(Account account : accountTable) {
    				if(account.id == id) {
    					balance += balance;
    					return true;
    				}	
    		}
  	return false;

}
}