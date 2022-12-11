package com.armondHarerJSleepJS;

/**
 * Class untuk penerapan multithreading
 * @author Armond Harer
 */
public class ThreadingObject extends Thread {
	
	/**
	 * @param name	| nama thread
	 */
	public ThreadingObject (String name) {
		super(name);
		start();
	}
	
	/**
	 * Meng-print nama dan ID tiap thread
	 */
	public void run(){
	      System.out.println(this.getName() + " is running");
	      System.out.println("Thread ID : " + this.getId());
	    }
	  
}
