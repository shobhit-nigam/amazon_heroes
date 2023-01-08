package information;

/*entity details for a RouteRequest from a user
 * access 7 storage of RouteRequest details
 * 
 * attributes:-
 * routeRequestId - unique ID
 * startStopId - unique stop ID from where route should begin
 * endStopId - unique stop ID where the route should end
 * startStopName - start stop name, scenario where stop is not supported & does not have an ID
 * endStopName - end stop name, scenario where stop is not supported & does not have an ID
 * requesterId - empId of the user requesting the route 
 * 
 * 
 * 
 */


public class RouteRequest {
	private int routeRequestId;
	private int startStopId;
	private int endStopId;
	private String startStopName;
	private String endStopName;
	private int requesterId;
	private boolean routeExists;
	private boolean stopsExists;
	private int timing;
	public RouteRequest(int routeRequestId, int startStopId, int endStopId, int requesterId, boolean routeExists,
			int timing) {
		this.routeRequestId = routeRequestId;
		this.startStopId = startStopId;
		this.endStopId = endStopId;
		this.requesterId = requesterId;
		this.routeExists = routeExists;
		this.stopsExists = stopsExists;
		this.timing = timing;
	}
	public RouteRequest(int routeRequestId, String startStopName, String endStopName, int requesterId,
			boolean routeExists, int timing) {
		this.routeRequestId = routeRequestId;
		this.startStopName = startStopName;
		this.endStopName = endStopName;
		this.requesterId = requesterId;
		this.routeExists = routeExists;
		this.stopsExists = stopsExists;
		this.timing = timing;
	}
	public int getRouteRequestId() {
		return routeRequestId;
	}
	public int getStartStopId() {
		return startStopId;
	}
	public int getEndStopId() {
		return endStopId;
	}
	public String getStartStopName() {
		return startStopName;
	}
	public String getEndStopName() {
		return endStopName;
	}
	public int getRequesterId() {
		return requesterId;
	}
	public boolean isRouteExists() {
		return routeExists;
	}
	public boolean isStopsExists() {
		return stopsExists;
	}
	public int getTiming() {
		return timing;
	}
	
	
	
	

}
