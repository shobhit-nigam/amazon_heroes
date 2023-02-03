package assets;

import customExceptions.ApplicationException;
import managers.IdManager;

/**
 * The class AssetFactory is a Simple Factory implementation which returns new instances based on
 * parameters independent of their ID attribute.
 * The IDs for each of the instances is a unique integer, which is provided by the IdManager instance
 * [except for User class where unique id is the user's Employee ID].
 * AssetFactory is a Singleton implementation as well because it controls single-point creation of
 * all instances for classes under package - assets.
 * AssetFactory is utilised in the Upper-Layer/Operations package for taking console inputs and
 * returning appropriate instances. As well as to transmit data between Upper Layer-to-Middle Layer
 * /Operations package-to-Managers package.
 **/

public class AssetFactory {

  private static AssetFactory assetFactory;

  public static AssetFactory getInstance() {
    if (assetFactory == null) {
      assetFactory = new AssetFactory();
    }
    return assetFactory;
  }

  public Bus getBusInstance(int availability, int busType, String vehicleNo)
          throws ApplicationException {
    int busId = IdManager.getInstance().getNewId("bus");

    Bus bus = new Bus(busId, availability, busType, vehicleNo);

    return bus;
  }

  public BusPass getBusPassInstance(int userId, int routeId, int busId, int timing)
          throws ApplicationException {
    int busPassId = IdManager.getInstance().getNewId("buspass");

    BusPass busPass = new BusPass(busPassId, userId, routeId, busId, timing);

    return busPass;
  }

  public Feedback getFeedbackInstance(int userId, String comment) throws ApplicationException {
    int feedbackId = IdManager.getInstance().getNewId("feedback");

    Feedback feedback = new Feedback(feedbackId, userId, comment);

    return feedback;
  }

  public Route getRouteInstance(int stops[], int[] stopRanks) throws ApplicationException {
    int routeId = IdManager.getInstance().getNewId("route");

    Route route = new Route(routeId, stops, stopRanks);

    return route;
  }

  public RouteRequest getRouteRequestInstance(int startStop, int endStop,
                                              int requesterId, boolean routeExists,
                                              int timing) throws ApplicationException {
    int routeRequestId = IdManager.getInstance().getNewId("routerequest");

    RouteRequest routeRequest = new RouteRequest(routeRequestId, startStop, endStop,
            requesterId, routeExists, timing);

    return routeRequest;
  }

  public RouteRequest getRouteRequestInstance(String startStopName, String endStopName,
                                              int requesterId, boolean routeExists,
                                              int timing) throws ApplicationException {
    int routeRequestId = IdManager.getInstance().getNewId("routerequest");

    RouteRequest routeRequest = new RouteRequest(routeRequestId, startStopName, endStopName,
            requesterId, routeExists, timing);

    return routeRequest;
  }

  public User getUserInstance(int employeeId, String fName, String lName,
                              String email, String contactNo, String emergencyContactNumber,
                              String emergencyContactName, String bloodGroup,
                              String password) {

    return new User(employeeId, fName, lName, email,
            contactNo, emergencyContactNumber,
            emergencyContactName, bloodGroup,
            password);
  }

  public Stop getStopInstance(String name) throws ApplicationException {
    int stopId = IdManager.getInstance().getNewId("stop");

    Stop stop = new Stop(stopId, name);

    return stop;
  }
}