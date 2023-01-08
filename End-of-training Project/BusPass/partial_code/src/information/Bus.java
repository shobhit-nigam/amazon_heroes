package information;


/*
 * retrieval & storage of bus details 
 * 
 * 
 * 
 */

public class Bus {
	private int busId;
	private int routeId;
	private int busType;
	private int availability;
	private int timing;
	private String busNo;
	
	
	public Bus(int busId, int busType, int availability, String busNo) {
		this.busId = busId;
		this.busType = busType;
		this.availability = availability;
		this.busNo = busNo;
		this.routeId = 0;
		this.timing = -1;
	}
	public int getBusId() {
		return busId;
	}
	public int getRouteId() {
		return routeId;
	}
	public int getBusType() {
		return busType;
	}
	public int getAvailability() {
		return availability;
	}
	public int getTiming() {
		return timing;
	}
	public void setTiming(int timing) {
		this.timing = timing;
	}
	public String getBusNo() {
		return busNo;
	}
	
	
}
