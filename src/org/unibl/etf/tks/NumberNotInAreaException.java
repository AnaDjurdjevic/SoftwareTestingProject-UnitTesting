package org.unibl.etf.tks;
/**
 * <h1>Number Not In Area Exception</h1>
 * The NumberNotInAreaException is an exception class that indicates a number is out of the allowed range.
 * It extends the Exception class and provides constructors for both default and custom error messages.
 * In the case of this program, it refers to the integer part of the 'currentValue' parameter.
 * <p>
 * @author AnaDjurdjevic
 * @version 1.0
 */
public class NumberNotInAreaException extends Exception{
	
	/**
	 * Constructs a new NumberNotInAreaException with a default error message.
	 * The default error message is "Number out of bounds!"
	 */
	public NumberNotInAreaException() {
		super("Broj izvan granica!");
	}
	
	/**
	 * Constructs a new NumberNotInAreaException with a custom error message.
	 * @param msg The custom error message to be associated with the exception.
	 */
	NumberNotInAreaException(String msg){
		super(msg);
	}
}
