package com.armondHarerJSleepJS;

/**
 * 
 * @author Armond Harer
 *
 * @param <T>
 */
public interface Predicate <T> {
	/**
	 * 
	 * @param pred | arg predicate data
	 * @return args data
	 */
	boolean predicate(T pred);
}
