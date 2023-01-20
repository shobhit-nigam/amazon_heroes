package operations;

import information.User;
import customExceptions.*;
import managers.UserManager;
import java.util.Scanner;

/*
 * new user:
 * sign-up screen
 * 	- create account 
 * 		- if successful, user is routed to the user screen
 * 		- if unsuccessful, routed back to user account control screen 
 * sign-in screen
 * 	- login with empId & password
 * 		- if login successful, user homescreen of app
 * 		- if unsuccessful (after 3 tries), routed back to user account control screen 
 */

public class UserLoginOperation extends BaseOperation{
	
	private final static int maxLoginTries = 3;
	private static int loginTries = 0;
	
	public boolean showMenu() throws AppException{
		boolean exitCode = false;
		String choice = "";
		Scanner objs = OperationFactory.getScannerInstance();
		
		while(!exitCode) {
			System.out.println("welcome to the user sign-in/sign-up page");
			System.out.println("\n1. Existing User " + 
							"\n2. New User" + 
							"\n0. Exit\n");
			
			choice = objs.next();
			
			switch (choice) {
			case "0":
				exitCode = true;
				break;
			
			case "1":
				try {
					setLoginDetails();
				}catch(UserException obje) {
					System.out.println("returning to previous menu as an exception occurred");
					System.out.println(obje.getMessage());
				}
				break;
			case "2":
				try {
					createAccount();
				}catch (UserException obje) {
					System.out.println("returning to previous menu as an exception occurred");
					System.out.println(obje.getMessage());
				}
				break;
				
			default:
				System.out.println("please enter a valid option");
			}
		}
		System.out.println("returning to main menu");
		return true;
		
	}
	
	private void createAccount() throws AppException, UserException {
		System.out.println("\n create a new user account");
		System.out.println("\nplease enter the details as prompted" + 
						"\npress enter once to confirm" + 
						"\npress enter twice to return to previous menu");
		
		// to be coded
	}
	
	private void login(int userId, String password)throws AppException, UserException{
		if (UserManager.getInstance().isValidUserPassword(userId, password)) {
			System.out.println("user login successfull");
			OperationFactory.getUserOperationInstance().showMenu(userId);
		}else {
			System.out.println("please recheck the credentials \n");
			setLoginDetails();
		}
		
	}
	
	private boolean setLoginDetails() throws AppException, UserException {
		loginTries += 1;
		System.out.println("\nUser Login \n");
		System.out.println("enter employee ID : \n");
		int userId = this.getUserId();
		
		System.out.println("Enter password : \n");
		String password = this.getPassword();
		
		if (loginTries > maxLoginTries) {
			System.out.println("max login attempts exceeded\n returning to home");
			loginTries = 0;
			return false;
		}
		login(userId, password);
		return true;
		
	}
	
	

	public static UserLoginOperation getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
