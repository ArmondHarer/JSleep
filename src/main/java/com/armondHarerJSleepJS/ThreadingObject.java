package com.armondHarerJSleepJS;

public class ThreadingObject extends Thread {
	
	public ThreadingObject (String name) {
		super(name);
	}
	
	public void run(){
	      System.out.println(Thread.currentThread().getName() + " is running");
	      System.out.println("Thread ID : " + Thread.currentThread().getId());
	    }
	  
}
