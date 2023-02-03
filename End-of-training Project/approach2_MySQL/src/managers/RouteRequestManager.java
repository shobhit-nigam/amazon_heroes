package managers;

import assets.RouteRequest;
import customExceptions.ApplicationException;
import queryHelper.QueryBuilder;

/**
 * The class RouteRequestManager is a child class of BaseManager.
 * It works as a middle layer between the dbTools package/Lower Layer and the Operations
 * package/Upper Layer.
 * It contains functions related to RouteRequest table such as read, create a record, validate data
 * from table, operation specific functions which require db support, etc.
 * It is used by the Upper Layers/Operations classes.
 * It utilizes Lower Layer/dbTools package and helper classes via the parent - BaseManager which
 * converts system exceptions to ApplicationExceptions.
 **/

public class RouteRequestManager extends BaseManager {

  private static RouteRequestManager routeRequestManager;

  public static RouteRequestManager getInstance() {
    if (routeRequestManager == null) {
      routeRequestManager = new RouteRequestManager();
    }
    return routeRequestManager;
  }

  public void create(RouteRequest routeRequest) throws ApplicationException {

    QueryBuilder queryBuilder = this.getInsertInstance()
            .onTable("routerequest")
            .insertValue("routerequestid", routeRequest.getRouteRequestId())
            .insertValue("startstop", routeRequest.getStartStopId())
            .insertValue("endstop", routeRequest.getEndStopId())
            .insertValue("startstopname", routeRequest.getStartStopName())
            .insertValue("endstopname", routeRequest.getEndStopName())
            .insertValue("requesterid", routeRequest.getRequesterId())
            .insertValue("routeexists", routeRequest.isRouteExists())
            .insertValue("stopsexist", routeRequest.isStopsExist())
            .insertValue("timing", routeRequest.getTiming());

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);
  }
}
