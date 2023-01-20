package operations;

import java.util.Scanner;
import customExceptions.*;

/*
 * Home page or outer layer 
 * 
 * Menu:-
 * 0. Exit
 * 1. Admin
 * 2. User
 * 3. Visitor
 *
 */

public class AppDriver {
	public void initiate() {
		boolean exitCode = false;
		Scanner inputObj = new Scanner(System.in);
		while(!exitCode) {
			System.out.println("Welcome to Amazon's BusPass Management");
			System.out.println("\nChoose your category :");
			System.out.println("\n1. Admin \n2. User \n3. Visitor \n0. Exit\n");
			int choice =  inputObj.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Welcome Administrator\n");
				// Admin code
				try {
				OperationFactory.getAdminLoginInstance().showMenu();
				} catch (AppException obje) {
					obje.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Welcome User\n");
				// User code
				break;
			case 3:
				System.out.println("Welcome Visitor\n");
				// Visitor code
				break;
			case 0:
				System.out.println("You have chosen to exit\n");
				exitCode = true;
				break;
			default:
				System.out.println("Please enter a valid operation");
			}
			
		}
		inputObj.close();
		System.out.println("Thank you !");
		
	}
}
