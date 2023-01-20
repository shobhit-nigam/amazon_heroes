package operations;

import information.Admin;
import customExceptions.*;

/*
 * log-in screen for Admin
 * use Admin Id & password 
 * 		- on successful login, routed to the Admin Operation page of the application
 * 		- on unsuccessful even after 3 tries, routed back to application home screen
 */


// Singleton as only 1 ADMIN is Hard-Coded
public class AdminLoginOperation extends BaseOperation{
	
	private String adminId = Admin.getAdminobjInstance().getAdminID();
	private String password = Admin.getAdminobjInstance().getAdminPassword();
	
	private static int loginTries = 1;
	private final static int maxLoginTries = 3;

	private static AdminLoginOperation adminLogin;
	
	public static AdminLoginOperation getInstance() {
		if (adminLogin == null){
			adminLogin= new AdminLoginOperation();
		}
		return adminLogin;
	}
	
	public void showMenu() throws AppException {
		try {
			setLoginDetails();
		} catch (UserException obje) {
			System.out.println("something went wrong, please retry after sometime");
		}
	}
	
	private void login(String adminId, String password) throws AppException, UserException {
		if(adminId.trim().equals(this.adminId) && password.equals(this.password)) {
			System.out.println("login successful");
			OperationFactory.getAdminOperationInstance().showMenu();
		}
		else {
			System.out.println("please enter correct ID & password");
			setLoginDetails();
		}
	}
	
	private boolean setLoginDetails() throws AppException, UserException{
		System.out.println("\n admin login");
		loginTries += 1;
		
		System.out.println("enter login ID   :   \n");
		//String userId = this.getAdminId();
		
		System.out.println("enter password   :   \n");
		//String password = this.getAdminPassword();
		
		if (loginTries > maxLoginTries) {
			System.out.println("max login tries exceeded, returning to home");
			loginTries=0;
			return false;
		}
		
		//login(userId, password);
		
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
