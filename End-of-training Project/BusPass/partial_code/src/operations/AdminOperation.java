package operations;

import information.Admin;
import customExceptions.*;
import java.util.Scanner;

/*
 * 
 * 
 * 
 */


public class AdminOperation extends BaseOperation{
	public boolean showMenu() throws AppException {
		boolean exitCode = false;
		Scanner inputObj = new Scanner(System.in);
		int choice ;
		
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
			
			choice = inputObj.nextInt();
			
		switch(choice) {
		
		}

			
		}
		System.out.println("returning to previous menu");
	return true;	
	}

}
