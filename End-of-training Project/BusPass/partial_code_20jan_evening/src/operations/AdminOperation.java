package operations;

import information.Admin;
import information.Bus;
import information.Route;
import information.Stop;
import managers.BusManager;
import managers.RouteManager;
import managers.StopManager;
import managers.SeatManager;

import customExceptions.*;
import java.util.Scanner;

/* child class of BaseOperation
 * all admin actions happen through this class, after a successful login
 * 
 */


public class AdminOperation extends BaseOperation{
	public boolean showMenu() throws AppException {
		boolean exitCode = false;
		String choice ;
		
		while(!exitCode) {
			System.out.println("welcome to the Admin Operations Menu");
			System.out.println("please select an option");
			
			System.out.println("\n1. Bus Control Menu\n" + 
					"2. Route Control Menu\n" +
					"3. Change Bus & Route assiggnment\n" +
					"4. Change type of a bus\n" + 
					"5. display number of buses of each type\n" + 
					"6. display timings & route for each bus\n" +
					"0. exit to main menu");
			
			choice = OperationFactory.getScannerInstance().next();
			
		switch(choice) {
		case "0":
			exitCode = true;
			break;
			
		case "1":
			busControlMenu();
			break;
			
		case "2":
			routeControlMenu();
			break;
			
		case "3":
			try {
			assignBusToRoute();
			} catch (UserException obje) {
				this.printMenuException(obje);
			}
			break;
		
		case "4":
			changeBusTypeMenu();
			break;
			
		case "5":
			displayBusCountofEachType();
			break;
			
		case "6":
			displayBusTimingsAndRoutes();
			break;
			
		default:
			System.out.println("not a valid option, please re-enter\n");
		
		}

			
		}
		System.out.println("returning to previous menu");
	return true;	
	}



	private boolean routeControlMenu() throws AppException{
		boolean exitCode = false;
		String choice = "";
		
		while(!exitCode) {
		System.out.println("\nwelcome to the Route Control Menu");
		System.out.println("\nplease select an option : \n");
		
		System.out.println("1. Add a new route\n" + 
						"2. Remove an exisiting Route\n" + 
						"3. Add a new Stop\n " + 
						"4. View all routes with their stops \n" + 
						"0. Return to Admin Menu\n");
		
		choice = OperationFactory.getScannerInstance().next();
		
		switch(choice) {
		case "0":
			exitCode = true;
			break;
		case "1":
			try {
				addRoute();
			}
			catch (UserException obje) {
				this.printMenuException(obje);
			}
			break;
			
		case "2":
			try {
				removeRoute();
			}
			catch (UserException obje) {
				this.printMenuException(obje);
			}
			break;
			
		case "3":
			try {
				addStop();
			}
			catch (UserException obje) {
				this.printMenuException(obje);
			}
			break;
			
		case "4":
			displayOnlyRoutes();
			break;
		default:
			System.out.println("please enter valid option");
		}
		}
	System.out.println("returning to the previous menu");		
	return true;	
	}
	
	private boolean addRoute() throws AppException, UserException{
		System.out.println("please enter the new route details:");
		System.out.println("number of stops:\n");
		//int stopCount = this.getStopCount();
		
		System.out.println("<to add new stop names, please go to the previous menu>\n");
		System.out.println("FYI, supported stops:\n");
		
		StopManager.getInstance().displayAllStops();
		
		return true;
	}

	private boolean busControlMenu() throws AppException{
		boolean exitCode = false;
		String choice = "";
		
		while(!exitCode) {
		System.out.println("\nwelcome to the Bus Control Menu");
		System.out.println("\nplease select an option : \n");
		
		System.out.println("1. Add a new bus\n" + 
						"2. Remove an exisiting bus\n" + 
						"3. Show all busses\n " +  
						"0. Return to Admin Menu\n");
		
		choice = OperationFactory.getScannerInstance().next();
		
		switch(choice) {
		case "0":
			exitCode = true;
			break;
		case "1":
			try {
				addBus();
			}
			catch (UserException obje) {
				this.printMenuException(obje);
			}
			break;
			
		case "2":
			try {
				removeBus();
			}
			catch (UserException obje) {
				this.printMenuException(obje);
			}
			break;
			
		case "3":
			displayOnlyBuses();
			break;
		default:
			System.out.println("please enter valid option");
		}
		}
	System.out.println("returning to the previous menu");
	return true;	
	}

	private boolean changeBusTypeMenu() throws AppException{
		boolean exitCode = false;
		String choice = "";
		
		while(!exitCode) {
		System.out.println("\nwelcome to the change Bus type Menu");
		System.out.println("\nplease select an option : \n");
		
		System.out.println("1. Change type of an Active Bus" + 
						"2. Change type of an Inactive bus\n" + 
						"3. Show all busses\n " +  
						"0. Return to Admin Menu\n");
		
		choice = OperationFactory.getScannerInstance().next();
		
		switch(choice) {
		case "0":
			exitCode = true;
			break;
		case "1":
			try {
				changeActiveBusType();
			}
			catch (UserException obje) {
				this.printMenuException(obje);
			}
			break;
			
		case "2":
			try {
				changeInactiveBusType();
			}
			catch (UserException obje) {
				this.printMenuException(obje);
			}
			break;
			
		case "3":
			displayOnlyBuses();
			break;
		default:
			System.out.println("please enter valid option");
		}
		}
	System.out.println("returning to the previous menu");
	return true;	
	}

	private void displayOnlyBuses() throws AppException {
		System.out.println("Note: Timing --> displayed in minutes\n" + 
						"Timing= -1 means no start timing assigned to bus\n" + 
						"route ID = 0 means no route assigned to the bus");
		BusManager.getInstance().displayAllBuses();
	}

	private void displayOnlyroutes() throws AppException{
	System.out.println("\nlist of all routes:");
	RouteManager.getInstance().displayAllRoutes();
	}
	
	private boolean addStop() throws UserException, AppException {
		System.out.println(("\nsupprted stops: \n"));
		StopManager.getInstance().displayAllStops();
		
		System.out.println("please provide a stop name to add :\n");
		//String stopName = this.getStopName();
		
		//code to be added
		
		
		return true;
	}
	
	private boolean changeActiveBusType() throws AppException, UserException {
		// code to be added
		return true;
	}
	private boolean changeInactiveBusType() throws AppException, UserException {
		// code to be added
		return true;
	}
	private boolean removeRoute() throws AppException, UserException {
		//code to be added 
		return true;
	}
	private boolean assignBusToRoute() throws AppException, UserException {
		//code to be added 
		return true;
		
	}
	private void displayBusCountofEachType()throws AppException{
		//code to be added 
		return;	
	}
	
	private boolean addBus() throws AppException, UserException {
		//code to be added 
		return true;
		
	}	
	
	private boolean removeBus() throws AppException, UserException {
		//code to be added 
		return true;
		
	}
	
	private void displayBusTimingsAndRoutes()throws AppException {
		//code to be added 
		return;	
	}
	private void displayOnlyRoutes()throws AppException {
		//code to be added 
		return;	
	}
	
}

