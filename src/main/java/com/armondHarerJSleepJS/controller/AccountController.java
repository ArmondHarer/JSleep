package com.armondHarerJSleepJS.controller;

import com.armondHarerJSleepJS.Algorithm;
import com.armondHarerJSleepJS.Predicate;
import com.armondHarerJSleepJS.Account;
import com.armondHarerJSleepJS.Renter;
import com.armondHarerJSleepJS.dbjson.*;

import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;
import java.util.Objects;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	@JsonAutowired(value = Account.class, filepath ="src/main/java/com/json/account.json")
    public static JsonTable<Account> accountTable;
	static {
		try {
			accountTable = new JsonTable<>(Account.class, "src/main/java/com/json/account.json");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z](?!.*\\.)";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?!.*\\s)[a-zA-Z0-9_\\W]{8,}$";
    public static final Pattern PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    
    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
    
    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password) throws NoSuchAlgorithmException{
    	 if(accountTable == null){
             return null;
         }

         try {

             MessageDigest md5 = MessageDigest.getInstance("MD5");
             byte[] messageDigest = md5.digest(password.getBytes());
             BigInteger no = new BigInteger(1, messageDigest);
             
             String hashtext = no.toString(16);
             while (hashtext.length() < 32) {
                 hashtext = "0" + hashtext;
             }
             password = hashtext;
         }

         catch (NoSuchAlgorithmException e) {
             throw new RuntimeException(e);
         }

         final Predicate<Account> emailPred = pred-> pred.email.equals(email);

         Account foundEmail = Algorithm.<Account>find(accountTable, emailPred);
         if (Algorithm.exists(accountTable, foundEmail)) {
             String finalPassword = password;
             final Predicate<Account> passPred = pred-> pred.password.equals(finalPassword);
             Account foundPassword = Algorithm.<Account>find(accountTable, passPred);
             if (Algorithm.exists(accountTable, passPred)){
                 return foundPassword;
             } else{
                 return null;
             }
         } else{
             return null;
         }
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
            		throws NoSuchAlgorithmException{
    	Account beforeEncrypt = new Account(name, email, password);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            password = hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Account newAccount = new Account(name, email, password);
        if (!name.isBlank() /*&& beforeEncrypt.validate()*/) {
            try{
              accountTable.add(newAccount);
              accountTable.writeJson(accountTable, accountTable.filepath);
        } catch(Throwable t){
            t.printStackTrace();
       }
            return newAccount;
        }else
            return null;
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
    	for(Account findaccount : accountTable) {
            if(findaccount.renter == null && findaccount.id == id) {
                Renter renter = new Renter(username, address, phoneNumber);
                findaccount.renter = renter;
                return renter;
            	}
    		}
    	return null;
    }
    
    
    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id,
            @RequestParam double balance) {
    	 if(accountTable == null){
             return false;
         }
         final Predicate<Account> idFilter = pred -> (id == pred.id);
         if(Algorithm.exists(accountTable, idFilter)){
             Algorithm.find(accountTable, idFilter).balance += balance;
             return true;
         }else
             return false;
     }
}