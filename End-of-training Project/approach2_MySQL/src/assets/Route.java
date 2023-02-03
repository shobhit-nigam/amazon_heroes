package assets;

/**
 * The class Route acts as a POJO which holds entity details for a Route and its stops.
 * It supports retrieval and storage of Route details. It is used in Upper Layer-to-Middle
 * Layer/Operations package-to-Managers package data transmission.
 * About attributes :
 * routeId - Unique ID
 * stopIds - Array of Unique IDs for each stop location.
 * stopRanks - Array of each stop's consecutive rank in a Route. Value = 1, represents the start and Value = size
 * of array, represents the end route. Rank represents their position/order from start to end stop
 * in a route.
 **/

public class Route {

  private int routeId;
  private int[] stopIds;
  private int[] stopRanks;

  public Route(int routeId, int[] stopIds, int[] stopRanks) {
    this.routeId = routeId;
    this.stopIds = stopIds;
    this.stopRanks = stopRanks;
  }

  public int[] getStopIds() {
    return stopIds;
  }

  public int getRouteId() {
    return routeId;
  }

  public int[] getStopRanks() {
    return stopRanks;
  }
}
