package operations;

import java.util.Scanner;
import customExceptions.AppException;
import managers.*;
/*
 * 
 * Visitor class
 * who do not have an existing account & want to see general information
 *
 */

public class VisitorOperation {
	public boolean showMenu() {
		boolean exitCode = false;
		Scanner inputObj = new Scanner(System.in);
		while(!exitCode) {
			System.out.println("Welcome to Visitor Operations Menu");
			System.out.println("\nChoose your category :");
			System.out.println("\n1. View details for Available Routes and buses \n" + 
								"2. Display Seat Availability \n" + 
								"0. Exit to Main Menu");
			int choice =  inputObj.nextInt();
			switch (choice) {
			case 1:
				// code for displaying bus timings & routes
				displayBusTimingsRoutes();
				break;
			case 2:
				// code for displaying Seat Availability
				displaySeatAvailability();
				break;
			case 0:
				System.out.println("You have chosen to exit\n");
				exitCode = true;
				break;
			default:
				System.out.println("Please enter a valid operation");
				
			}
			
			}
		System.out.println("Returning to the previous menu");
		inputObj.close();
		
		return true;
	}

	private void displaySeatAvailability() {
		System.out.println("seats available = <code not implemented>");
//		SeatManager.getInstance().displaySeatPerRoute();
		
	}

	private void displayBusTimingsRoutes() {
		System.out.println("bus timings & routes = <code not implemented>");
//		BusManager.getInstance().displayBusTimingsAndRoutes();
		
	}
	
	

}
