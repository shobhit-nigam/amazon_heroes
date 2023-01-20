package customExceptions;

/*
 * 
 * system exceptions related to DB or class or file
 * throw a custom message      
 *
 */

public class AppException extends Exception{
	public AppException(String message) {
		//  some message & info to be displayed
		super(message);
	}

}
