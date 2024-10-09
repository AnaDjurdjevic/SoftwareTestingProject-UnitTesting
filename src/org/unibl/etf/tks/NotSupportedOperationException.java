package org.unibl.etf.tks;

/**
 * <h1>Not Supported Operation Exception</h1>
 * The NotSupportedOperationException is an exception class that indicates an attempt to use an unsupported operator.
 * It extends the Exception class and provides constructors for both default and custom error messages.
 * <p>
 * @author AnaDjurdjevic
 * @version 1.0
 */
public class NotSupportedOperationException extends Exception {
	
	/**
	 * Constructs a new NotSupportedOperationException with a default error message.
	 * The default error message is "Unsupported operator!".
	 */
	public NotSupportedOperationException() {
		super("Nepodržan operator!");
	}
	
	/**
	 * Constructs a new NotSupportedOperationException with a custom error message.
	 * @param msg The custom error message to be associated with the exception.
	 */
	NotSupportedOperationException(String msg){
		super(msg);
	}
}
