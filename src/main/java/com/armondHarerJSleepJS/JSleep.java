package com.armondHarerJSleepJS;

import java.util.List;
import java.io.IOException;

import com.armondHarerJSleepJS.dbjson.JsonDBEngine;
import com.armondHarerJSleepJS.dbjson.JsonTable;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Praktikum OOP 
 * JSleep - Backend untuk aplikasi Android
 * Current @version - 11/12/2022
 * @author Armond Harer
 *
 */
@SpringBootApplication
public class JSleep
{
		/**
		 * Main method untuk JSleep
		 * @param args data
		 * @throws IOException
		 */
	 	public static void main(String[] args) throws IOException
	    {	
		 	JsonDBEngine.Run(JSleep.class);
		 	SpringApplication.run(JSleep.class, args);
		 	Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
	    }
}