package managers;

import assets.Route;
import customExceptions.ApplicationException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import queryHelper.QueryBuilder;

/**
 * The class RouteManager is a child class of BaseManager.
 * It works as a middle layer between the dbTools package/Lower Layer and the Operations
 * package/Upper Layer.
 * It contains functions related to Route table such as read, create a record, validate data
 * from table, operation specific functions which require db support, etc.
 * It is used by the Upper Layers/Operations classes.
 * It utilizes Lower Layer/dbTools package and helper classes via the parent - BaseManager which
 * converts system exceptions to ApplicationExceptions.
 **/

public class RouteManager extends BaseManager {

  private static RouteManager routeManager;

  public static RouteManager getInstance() {
    if (routeManager == null) {
      routeManager = new RouteManager();
    }
    return routeManager;
  }

  public boolean create(Route route) throws ApplicationException {
    for (int i = 0; i < route.getStopIds().length; i++) {
      QueryBuilder queryBuilder = this.getInsertInstance()
              .insertValue("routeid", route.getRouteId())
              .insertValue("stopid", route.getStopIds()[i])
              .insertValue("stoprank", route.getStopRanks()[i])
              .onTable("route");

      String sqlQuery = this.buildQuery(queryBuilder);

      this.executeQuery(sqlQuery);

    }
    System.out.println("RouteID and Stops updated\n");
    return true;
  }

  public int[] getRoutes(int startStop, int endStop)
          throws ApplicationException {
    int[] startCommonRoutes = getRoutes(startStop);
    int[] endCommonRoutes = getRoutes(endStop);

    List<Integer> startRouteList = new ArrayList<>();
    List<Integer> routeIdList = new ArrayList<>();

    for (int startRouteId : startCommonRoutes) {
      startRouteList.add(startRouteId);
    }

    for (int endRouteId : endCommonRoutes) {
      if (startRouteList.contains(endRouteId)) {
        routeIdList.add(endRouteId);
      }
    }

    List<Integer> resultList = new ArrayList<>();

    for (int routeId : routeIdList) {
      int startStopRank = this.getStopRank(routeId, startStop);
      int endStopRank = this.getStopRank(routeId, endStop);

      if (startStopRank == 1 && startStopRank < endStopRank
              && startStopRank != -1 && endStopRank != -1) {
        resultList.add(routeId);
      }
    }

    int[] resultArray = new int[resultList.size()];

    for (int i = 0; i < resultList.size(); i++) {
      resultArray[i] = resultList.get(i);
    }
    return resultArray;
  }

  private int getStopRank(int routeId, int stopId) throws ApplicationException {

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns("stoprank")
            .onTable("route")
            .whereEq("routeid", routeId)
            .whereEq("stopid", stopId);

    String sqlQuery = this.buildQuery(queryBuilder);

    return this.getQueryNumber(sqlQuery);
  }

  public int[] getRoutes(int stopId) throws ApplicationException {
    String[] columns = {"routeid"};

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns(columns)
            .onTable("route")
            .whereEq("stopid", stopId);

    String sqlQuery = this.buildQuery(queryBuilder);

    ResultSet resultSet = this.getResultSet(sqlQuery);

    List<Integer> resultList = new ArrayList<>();

    while (this.isNextPresent(resultSet)) {
      resultList.add(this.getInt(resultSet, 1));
    }

    int[] resultArray = new int[resultList.size()];

    for (int i = 0; i < resultList.size(); i++) {
      resultArray[i] = resultList.get(i);
    }
    return resultArray;
  }

  public boolean delete(int routeIdToRemove) throws ApplicationException {

    QueryBuilder queryBuilder = this.getDeleteInstance()
            .onTable("route")
            .whereEq("routeid", routeIdToRemove);

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);

    return false;
  }

  public boolean displayAllRoutes() throws ApplicationException {
    String[] columns = {"routeid", "stopname"};

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns(columns)
            .onTable("routestopname");

    String sqlQuery = this.buildQuery(queryBuilder);

    ResultSet resultSet = this.getResultSet(sqlQuery);

    if (!this.isNextPresent(resultSet)) {
      System.out.println("No Route records were found");
      return false;
    }

    System.out.println("Route ID \t\t\t\t\t Stops from Start to End\n");

    String stopNamesString = "";
    String eachRecord = "";
    String currentStopName = "";

    int currentRouteId = 0;
    int previousRouteId = this.getInt(resultSet, 1);

    do {
      currentRouteId = this.getInt(resultSet, 1);
      currentStopName = this.getString(resultSet, 2);
      if (currentRouteId == previousRouteId) {
        stopNamesString += currentStopName + "--> ";
      } else {
        eachRecord = previousRouteId + "\t\t" +
                "--> " + stopNamesString;

        System.out.println(eachRecord);

        stopNamesString = currentStopName + "--> ";
        previousRouteId = currentRouteId;
      }
    } while (this.isNextPresent(resultSet));

    System.out.println(currentRouteId + "\t\t" +
            "--> " + stopNamesString);

    return true;
  }

  public boolean getAvailableBuses(int startStopId, int endStopId, int timing)
          throws ApplicationException {
    int[] routeIds = RouteManager
            .getInstance()
            .getRoutes(startStopId, endStopId);

    if (BusManager.getInstance().isBusAvailableForRoutesAndTiming(routeIds, timing)) {
      System.out.println("As per the provided details, the below Bus(es) are already " +
              "available and active for use.");

      BusManager
              .getInstance()
              .displayAvailableBusTimingsAndRoutes(routeIds, timing);

      return true;
    }
    return false;
  }
}

