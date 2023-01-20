package operations;

import customExceptions.*;

public class BaseOperation {
	
	public void printMenuException(UserException obje) {
		System.out.println("Returning to previous menu as an issue has occurred\n");
		System.out.print("issue: ");
		System.out.println(obje.getMessage());
	}

}
