package managers;

import assets.Bus;
import customExceptions.ApplicationException;
import dbTools.TimeConverter;
import java.sql.ResultSet;
import queryHelper.QueryBuilder;

/**
 * The class BusManager is a child class of BaseManager.
 * It works as a middle layer between the dbTools package/Lower Layer and the Operations
 * package/Upper Layer.
 * It contains functions related to Bus table such as read, create a record, validate data
 * from table, operation specific functions which require db support, etc.
 * It is used by the Upper Layers/Operations classes.
 * It utilizes Lower Layer/dbTools package and helper classes via the parent - BaseManager which
 * converts system exceptions to ApplicationExceptions.
 **/

public class BusManager extends BaseManager {

  private static BusManager busManager;

  public static BusManager getInstance() {
    if (busManager == null) {
      busManager = new BusManager();
    }
    return busManager;
  }

  public void create(Bus bus) throws ApplicationException {
    QueryBuilder queryBuilder = this.getInsertInstance()
            .onTable("bus")
            .insertValue("busid", bus.getBusId())
            .insertValue("routeid", bus.getRouteId())
            .insertValue("availability", bus.getAvailability())
            .insertValue("bustype", bus.getBusType())
            .insertValue("timing", bus.getTiming())
            .insertValue("vehicleno", bus.getVehicleNo());

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);
  }

  public void update(int busId, String field, int newValue) throws ApplicationException {
    QueryBuilder queryBuilder = this.getUpdateInstance()
            .onTable("bus")
            .updateValue(field, newValue)
            .whereEq("busid", busId);

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);
  }

  public void displayBusCount(String criteria) throws ApplicationException {
    String[] columns = {criteria, "count(*)"};

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns(columns)
            .onTable("bus");

    String sqlQuery = this.buildQuery(queryBuilder);

    sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1) +
            " group by " +
            criteria +
            " order by " +
            criteria +
            " desc;";

    String[] headers = {"BUS TYPE", "NUMBER OF BUSES"};

    this.executeQuery(sqlQuery, headers);
  }

  public boolean displayAvailableBusTimingsAndRoutes() throws ApplicationException {
    String[] columns = {"busid", "routeid", "timing", "stopname"};

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns(columns)
            .onTable("availableroutebusmap");

    String sqlQuery = this.buildQuery(queryBuilder);

    ResultSet resultSet = this.getResultSet(sqlQuery);

    if (!this.isNextPresent(resultSet)) {
      System.out.println("No available Records found");
      return false;
    }

    this.goToPrevious(resultSet);

    displaySchedule(resultSet, true);

    return true;
  }

  public boolean displayAvailableBusTimingsAndRoutes(int[] routeIds, int timing)
          throws ApplicationException {
    System.out.println("BUS ID\tROUTE ID\tSTART TIMING\tSTOPS FROM START TO END");

    int foundResultsCounter = 0;

    for (int routeId : routeIds) {

      String[] columns = {"busid", "routeid", "timing", "stopname"};

      QueryBuilder queryBuilder = this.getSelectInstance()
              .selectColumns(columns)
              .onTable("availableroutebusmap")
              .whereEq("routeid", routeId)
              .whereEq("timing", timing);
      String sqlQuery = this.buildQuery(queryBuilder);

      ResultSet resultSet = this.getResultSet(sqlQuery);

      if (this.isNextPresent(resultSet)) {
        foundResultsCounter++;

        displaySchedule(resultSet, false);
      }
    }

    if (foundResultsCounter > 0) {
      return true;
    }
    return false;
  }

  public boolean displaySchedule(ResultSet resultSet, boolean headingSwitch) throws ApplicationException {
    if (!this.isNextPresent(resultSet)) {
      return false;
    }

    if (headingSwitch) {
      System.out.println("BUS ID\tROUTE ID\tSTART TIMING\tSTOPS FROM START TO END\t\t\t");
    }

    int previousBusId = this.getInt(resultSet, 1);
    int previousRouteId = this.getInt(resultSet, 2);

    String stopNamesString = "";
    String eachRecord = "";
    String currentStopName = "";

    int currentBusId = 0;
    int currentRouteId = 0;
    int currentTiming = 0;

    boolean firstRecordState = true;

    do {
      currentBusId = this.getInt(resultSet, 1);
      currentRouteId = this.getInt(resultSet, 2);
      currentStopName = this.getString(resultSet, 4);

      if (currentBusId == previousBusId && currentRouteId == previousRouteId
              && firstRecordState) {
        stopNamesString += currentStopName;
        firstRecordState = false;
      } else if (currentBusId == previousBusId && currentRouteId == previousRouteId) {
        stopNamesString += "-->" + currentStopName;
        currentTiming = this.getInt(resultSet, 3);
      } else {
        eachRecord = previousBusId + "\t\t\t\t" +
                previousRouteId + "\t\t\t\t" +
                TimeConverter.getTimeAsString(currentTiming) + "\t\t\t\t\t" +
                "-->" + stopNamesString + "\t\t";

        System.out.println(eachRecord);

        stopNamesString = currentStopName;

        currentTiming = this.getInt(resultSet, 3);

        previousBusId = currentBusId;
        previousRouteId = currentRouteId;
      }
    } while (this.isNextPresent(resultSet));

    System.out.println(currentBusId + "\t\t\t\t" +
            currentRouteId + "\t\t\t\t" +
            TimeConverter.getTimeAsString(currentTiming) + "\t\t\t\t\t" +
            "-->" + stopNamesString + "\t\t");

    return true;
  }

  // Clears routeId presence from all records in the bus table
  public boolean clearRouteAssignments(int routeId) throws ApplicationException {

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectAllColumns()
            .onTable("bus")
            .whereEq("routeid", routeId);

    String sqlQuery = this.buildQuery(queryBuilder);

    ResultSet resultSetOfBus = this.getResultSet(sqlQuery);

    if (!this.isNextPresent(resultSetOfBus)) { // No Buses are linked, No update required
      return false;
    }

    queryBuilder = this.getUpdateInstance()
            .onTable("bus")
            .updateValue("routeid", "NULL")
            .updateValue("timing", "NULL")
            .updateValue("availability", "bustype")
            .whereEq("routeid", routeId);

    sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);

    return true;
  }

  public void delete(int busIdToRemove) throws ApplicationException {
    QueryBuilder queryBuilder = this.getDeleteInstance()
            .onTable("bus")
            .whereEq("busid", busIdToRemove);

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);
  }

  public boolean isBusAvailableForRoutesAndTiming(int[] routeIds, int timing)
          throws ApplicationException {
    if (routeIds.length == 0) {
      return false;
    }

    for (int routeId : routeIds) {
      QueryBuilder queryBuilder = this.getSelectInstance()
              .selectAllColumns()
              .onTable("bus")
              .whereEq("routeid", routeId)
              .whereEq("timing", timing)
              .whereGt("availability", 0);

      String sqlQuery = this.buildQuery(queryBuilder);

      ResultSet resultSet = this.getResultSet(sqlQuery);

      if (this.isNextPresent(resultSet)) {
        return true;
      }
    }
    return false;
  }

  public boolean displayAllBuses() throws ApplicationException {
    String[] columns = {"busid", "routeid", "availability", "bustype", "timing", "vehicleno"};

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns(columns)
            .onTable("bus");

    String sqlQuery = this.buildQuery(queryBuilder);

    if (!this.hasResult(sqlQuery)) {
      System.out.println("No Bus Records Found");
      return false;
    }

    String[] headers = {"BUS ID", "ROUTE ID", "AVAILABILITY", "BUS TYPE", "TIMING", "VEHICLE NO"};
    this.executeQuery(sqlQuery, headers);

    return true;
  }

  public boolean hasRoute(int routeId, int busId) throws ApplicationException {
    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns("busid")
            .onTable("bus")
            .whereEq("routeid", routeId)
            .whereEq("busid", busId)
            .whereGt("routeid", 0);

    String sqlQuery = this.buildQuery(queryBuilder);

    ResultSet resultSet = this.getResultSet(sqlQuery);

    return this.isNextPresent(resultSet);
  }

  public boolean hasNoRoute(int busId) throws ApplicationException {

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns("busid")
            .onTable("bus")
            .whereEq("busid", busId)
            .whereEq("routeid", 0);

    String sqlQuery = this.buildQuery(queryBuilder);

    ResultSet resultSet = this.getResultSet(sqlQuery);

    return this.isNextPresent(resultSet);
  }

  public boolean isVehicleNoSame(int busId, String vehicleNo) throws ApplicationException {
    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns("busid")
            .onTable("bus")
            .whereEq("busid", busId)
            .whereEq("vehicleno", vehicleNo);

    String sqlQuery = this.buildQuery(queryBuilder);

    ResultSet resultSet = this.getResultSet(sqlQuery);

    return this.isNextPresent(resultSet);
  }

  public boolean isVehicleNoPresentWithOther(int busId, String vehicleNo) throws ApplicationException {
    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns("busid")
            .onTable("bus")
            .whereNeq("busid", busId)
            .whereEq("vehicleno", vehicleNo);

    String sqlQuery = this.buildQuery(queryBuilder);

    ResultSet resultSet = this.getResultSet(sqlQuery);

    return this.isNextPresent(resultSet);
  }
}
