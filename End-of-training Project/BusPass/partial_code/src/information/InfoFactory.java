package information;

import customExceptions.*;
import managers.*;

/*
 * Factory implementation 
 * Singleton 
 * 
 * single point creation of instances for all classes under package information
 * returns new instances 
 * 
 * InfoFactory is used in Operations for taking console inputs and returning appropriate instances 
 * also used to transmit data between operations & managers 
 * 
 */


public class InfoFactory {
	private static InfoFactory infoFactory;
	
	public static InfoFactory getInstance() {
		if (infoFactory == null) {
			infoFactory = new InfoFactory();
		}
		return infoFactory;
	}
	
	public Bus getBusInstance(int availability, int busType, String busNo) 
			throws AppException {
		int busId = IdManager.getInstance().getNewId("bus");
		
		Bus bus = new Bus(busId, availability, busType, busNo);
		return bus;
	}
	public User getUserInstance(String firstName, String lastName, int empId, 
								String email, String contactNo, String password, 
								String bloodGroup, String emergencyContactNo, String address) {
		
		return new User(firstName, lastName, empId, email, 
				contactNo, password, bloodGroup, 
				emergencyContactNo, address);
	}
	
	

}
