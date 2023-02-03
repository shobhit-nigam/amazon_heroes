package assets;

/**
 * The class RouteRequest acts as a POJO which holds entity details for a RouteRequest from a user.
 * It supports retrieval and storage of RouteRequest details. It is used in Upper Layer-to-Middle
 * Layer/Operations package-to-Managers package data transmission.
 * About attributes :
 * routeRequestId - Unique ID.
 * startStopId - Unique Stop ID from where the Route should begin.
 * endStopId - Unique Stop ID from where the Route should.
 * startStopName - Name of the Stop from where the Route should begin, for scenarios where a stop
 * is not supported yet and does not have a id.
 * endStopName - Name of the Stop where the Route should end, for scenarios where a stop
 * is not supported yet and does not have a id.
 * requesterId - Employee ID of the User requesting the Route.
 * routeExists - Stores boolean route existence state, if both stops are currently present in a
 * Route. Independent of start time.
 * stopsExist - Stores boolean stops existence state, if either of the stops are not supported and
 * do not have id(s).
 * timing - Start Timing requested for the Route.
 **/

public class RouteRequest {

  private int routeRequestId;
  private int startStopId;
  private int endStopId;
  private String startStopName;
  private String endStopName;
  private int requesterId;
  private boolean routeExists;
  private boolean stopsExist;
  private int timing;

  public RouteRequest(int routeRequestId, int startStop, int endStop, int requesterId,
                      boolean routeExists, int timing) {
    this.routeRequestId = routeRequestId;
    this.startStopId = startStop;
    this.endStopId = endStop;
    this.requesterId = requesterId;
    this.routeExists = routeExists;
    this.timing = timing;
    this.stopsExist = true;
  }

  public RouteRequest(int routeRequestId, String startStopName, String endStopName, int requesterId,
                      boolean routeExists, int timing) {
    this.routeRequestId = routeRequestId;
    this.startStopName = startStopName;
    this.endStopName = endStopName;
    this.requesterId = requesterId;
    this.timing = timing;
    this.stopsExist = false;
    this.routeExists = routeExists;

    if (routeExists) {
      this.routeExists = false;
    }
  }

  public String getStartStopName() {
    return startStopName;
  }

  public String getEndStopName() {
    return endStopName;
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

  public int getRequesterId() {
    return requesterId;
  }

  public boolean isRouteExists() {
    return routeExists;
  }

  public boolean isStopsExist() {
    return stopsExist;
  }

  public int getTiming() {
    return timing;
  }
}
