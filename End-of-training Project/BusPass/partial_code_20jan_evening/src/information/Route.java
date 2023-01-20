package information;

/*
 * Attributes:-
 * routeId - unique ID
 * stopIds[] - array of unique IDs for each stop location
 * stopRanks[] 	- position/order from start to end
 * 				- value =1, represents start of array
 * 				- value = size of array, represents the end of route
 * 				- rank represents their position/order from start to end stop in a route
 */

public class Route {
	private int routeId;
	private int[] stopIds;
	private int[] stopRanks;
	
	public Route(int routeId, int[] stopIds, int[] stopRanks) {
		this.routeId = routeId;
		this.stopIds = stopIds;
		this.stopRanks = stopRanks;
	}

	public int getRouteId() {
		return routeId;
	}

	public int[] getStopIds() {
		return stopIds;
	}

	public int[] getStopRanks() {
		return stopRanks;
	}
	
	
}
