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
	
	public BusPass getBussPassInstance(int busId, int userId, int routeId, int timing) 
			throws AppException {
		int busPassId = IdManager.getInstance().getNewId("buspass");
		BusPass busPass = new BusPass (busPassId, busId, userId, routeId, timing);
		return busPass;
	}
	
	public Feedback getFeedbackInstance(int userId, String comment) 
			throws AppException {
		int feedbackId = IdManager.getInstance().getNewId("feedback");
		Feedback feedback = new Feedback (feedbackId, comment, userId);
		return feedback;
	}
	
	public RouteRequest getRouteRequestInstance(int startStop, int endStop, int requesterId,
			boolean routeExists, int timing) throws AppException {
		int routeRequestId = IdManager.getInstance().getNewId("routerequest");
		RouteRequest routeRequest = new RouteRequest(routeRequestId, startStop, endStop, requesterId,
				routeExists, timing);
		return routeRequest;
	}
	
	public RouteRequest getRouteRequestInstance(String startStopName, String endStopName, int requesterId,
			boolean routeExists, int timing) throws AppException {
		int routeRequestId = IdManager.getInstance().getNewId("routerequest");
		RouteRequest routeRequest = new RouteRequest(routeRequestId, startStopName, endStopName, requesterId,
				routeExists, timing);
		return routeRequest;
	}
	
	public User getUserInstance(String firstName, String lastName, int empId, 
								String email, String contactNo, String password, 
								String bloodGroup, String emergencyContactNo, String address) {
		
		return new User(firstName, lastName, empId, email, 
				contactNo, password, bloodGroup, 
				emergencyContactNo, address);
	}
	
	public Stop getStopInstance(String name) throws AppException{
		int stopId = IdManager.getInstance().getNewId("stop");
		
		Stop stop = new Stop(stopId, name);
		return stop;
	}
	
	

}
