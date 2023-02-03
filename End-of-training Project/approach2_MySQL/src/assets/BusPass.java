package assets;

public class BusPass {

  /**
   * The class BusPass acts as a POJO which holds entity details for a user's BusPass.
   * It supports retrieval and storage of user's BusPass details. It is used in Upper Layer-to-Middle
   * Layer/Operations package-to-Managers package data transmission.
   * About attributes :
   * busPassId - Unique ID
   * routeId - Route ID for the user's BusPass
   * userId - BusPass owner ID
   * busId - Bus ID for the user's BusPass
   * timing - Is the start timing of a bus for the route. Stored in integer minutes for
   * the time of a day. Default value : -1
   **/

  private int busPassId;
  private int userId;
  private int busId;
  private int routeId;
  private int timing;

  public BusPass(int busPassId, int userId, int routeId, int busId, int timing) {
    this.busPassId = busPassId;
    this.userId = userId;
    this.busId = busId;
    this.routeId = routeId;
    this.timing = timing;
  }

  public int getBusPassId() {
    return busPassId;
  }

  public int getUserId() {
    return userId;
  }

  public int getBusId() {
    return busId;
  }

  public int getRouteId() {
    return routeId;
  }

  public int getTiming() {
    return timing;
  }
}
