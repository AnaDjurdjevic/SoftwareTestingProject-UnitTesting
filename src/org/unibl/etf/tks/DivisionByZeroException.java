package org.unibl.etf.tks;

/**
 * <h1>Division By Zero Exception</h1>
 * The DivisionByZeroException is an exception class that indicates an attempt to divide by zero.
 * It extends the Exception class and provides constructors for both default and custom error messages.
 * <p>
 * @author AnaDjurdjevic
 * @version 1.0
 */
public class DivisionByZeroException extends Exception{
	
	/**
	 * Constructs a new DivisionByZeroException with a default error message.
	 * The default error message is "Division by zero is not allowed!".
	 */
	public DivisionByZeroException() {
		super("Dijeljenje sa nulom nije dozvoljeno!");
	}
	
	/**
	 * Constructs a new DivisionByZeroException with a custom error message.
	 * @param msg The custom error message to be associated with the exception.
	 */
	DivisionByZeroException(String msg){
		super(msg);
	}
}
