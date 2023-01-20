package information;


/*
 * access & store user's BusPass details
 * attributes:- 
 * busPassId - unique 
 * routeId - route ID for the user's BusPass
 * userId - BusPass owner ID
 * busId - Bus ID for the user's BusPass
 * timing - start timing of a bus for the route (integer minutes) , default = -1 
 * 
 * 
 */

public class BusPass {
	private int busPassId;      //unique ID
	private int busId;
	private int userId;
	private int routeId;
	private int timing;
	
	
	public BusPass(int busPassId, int busId, int userId, int routeId, int timing) {
		this.busPassId = busPassId;
		this.busId = busId;
		this.userId = userId;
		this.routeId = routeId;
		this.timing = timing;
	}
	
	public int getBusPassId() {
		return busPassId;
	}
	public int getBusId() {
		return busId;
	}
	public int getUserId() {
		return userId;
	}
	public int getRouteId() {
		return routeId;
	}
	public int getTiming() {
		return timing;
	}
	
	

}
