package operations;

import customExceptions.*;


/*
 * after successful login, all user actions are performed through this class
 */

public class UserOperation extends BaseOperation{
	
	public boolean showMenu(int userId) throws AppException {
		
		boolean exitCode = false;
		String choice = "";
		
		while(!exitCode) {
			
			choice = OperationFactory.getScannerInstance().next();
			
			
		}
		System.out.println("returning to previous menu");
	return true	;
	}

}
