package operations;

import java.util.Scanner;


/*
 * Simple factory implementation 
 * returns new instances for all classes 
 * controls instance creation of upper layer
 */

public class OperationFactory {
	public static AdminLoginOperation getAdminLoginInstance() {
		return AdminLoginOperation.getInstance();
	}
	public static AdminOperation getAdminOperationInstance() {
		return new AdminOperation();
	}
	public static VisitorOperation getVisitorOperationInstance() {
		return new VisitorOperation();
	}
	
	public static Scanner getScannerInstance() {
		return new Scanner(System.in).useDelimiter("\n");
	}
	
	
}
