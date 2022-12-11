package com.armondHarerJSleepJS.controller;

import com.armondHarerJSleepJS.Algorithm;
import com.armondHarerJSleepJS.Account;
import com.armondHarerJSleepJS.Predicate;
import com.armondHarerJSleepJS.Renter;
import com.armondHarerJSleepJS.dbjson.*;

import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Objects;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

/**
 * Class Java yang akan berhubungan dengan interaksi akun di frontend
 * @author Armond Harer
 */
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
	
	/**
	 * Regex untuk verifikasi email dan password
	 * Untuk email menggunakan format local@domain
	 * local hanya terdiri dari angka dan huruf, dan domain hanya boleh menggunakan huruf (dan titik di tengah)
	 * Untuk password wajib memiliki 1 huruf kapital, 1 huruf lowercase, 1 angka, minimal 8 karakter dan tidak ada whitespace
	 */
	public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z](?!.*\\.)";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?!.*\\s)[a-zA-Z0-9_\\W]{8,}$";
    public static final Pattern PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    
    /**
     * Mengambil tabel Json
     */
    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
    
    /**
     * Login menggunakan akun yang sudah ter-register
     * @param email		| Alamat email yang terregistrasi dalam akun
     * @param password	| Password akun
     * @return Akun yang akan digunakan dalam Android
     * @throws NoSuchAlgorithmException
     */
    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password) throws NoSuchAlgorithmException{
    	for(Account account : getJsonTable()){
            String hash = hash(password);
            if(account.email.equals(email) && account.password.equals(hash)){
                return account;
            }
        }
        return null;
    	}
    
    @GetMapping
    String index() { return "account page"; }

    /**
     * Registrasi akun baru
     * @param name		| Nama user
     * @param email		| Alamat email user
     * @param password	| Password
     * @return Akun baru yang sudah teregistrasi 
     * @throws NoSuchAlgorithmException
     */
    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
            		throws NoSuchAlgorithmException{
    	Matcher matcherEmail = PATTERN_EMAIL.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Matcher matcherPassword = PATTERN_PASSWORD.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));
        if (findAccount == null && matchEmail && matchFoundPassword) {
            final String generatedPassword;
            generatedPassword = hash(password);
            Account account = new Account(name, email, generatedPassword, 0.00);
            accountTable.add(account);
            return account;
        } return null;
    }
    
    /**
     * Registrasi renter untuk akun
     * @param id			| ID dari akun yang meng-register renter
     * @param username		| Nama dari renter
     * @param address		| Alamat renter (Mengikuti regex di class Renter)
     * @param phoneNumber	| Nomor telepon renter (Mengikuti regex di class Renter)
     * @return renter yang terikat pada account tertentu
     */
    @PostMapping("{id}/registerRenter")
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
                try {
                  accountTable.writeJson();
                }catch(Throwable t) {
                	t.printStackTrace();
                }
                return renter;
            	}
    		}
    	return null;
    }
    
    /**
     * Top-up balance akun 
     * @param id		| ID dari akun yang ingin di-top up
     * @param balance	| Jumlah uang yang ingin di-top up
     * @return Konfirmasi top up berhasil
     */
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
    
    /**
     * Enkripsi password menggunakan MD5 untuk registrasi dan login
     * @param password | String password yang belum dieknripsi
     * @return password yang telah dienkripsi 
     * @throws NoSuchAlgorithmException
     */
    public static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}