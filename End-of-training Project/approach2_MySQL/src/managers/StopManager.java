package managers;

import assets.Stop;
import customExceptions.ApplicationException;
import queryHelper.QueryBuilder;

/**
 * The class StopManager is a child class of BaseManager.
 * It works as a middle layer between the dbTools package/Lower Layer and the Operations
 * package/Upper Layer.
 * It contains functions related to Stop table such as read, create a record, validate data
 * from table, operation specific functions which require db support, etc.
 * It is used by the Upper Layers/Operations classes.
 * It utilizes Lower Layer/dbTools package and helper classes via the parent - BaseManager which
 * converts system exceptions to ApplicationExceptions.
 **/

public class StopManager extends BaseManager {

  private static StopManager stopManager;

  public static StopManager getInstance() {
    if(stopManager == null) {
      stopManager = new StopManager();
    }
    return stopManager;
  }

  // Returns stopId for searched stopName from stopTable
  public int getStopIdForName(String stopName) throws ApplicationException {
    String[] columns = {"stopid"};

    QueryBuilder queryBuilder = this.getSelectInstance()
                                    .selectColumns(columns)
                                    .onTable("stop")
                                    .whereEq("stopname", stopName);
    String sqlQuery = this.buildQuery(queryBuilder);

    int stopId = this.getQueryNumber(sqlQuery);

    return stopId;
  }

  public boolean displayAllStops() throws ApplicationException {

    String[] columns = {"stopid", "stopname"};

    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns(columns)
            .onTable("stop");

    String sqlQuery = this.buildQuery(queryBuilder);

    if(!this.hasResult(sqlQuery)) {
      return false;
    }

    String[] headers = {"STOP ID", "STOP NAME"};

    this.executeQuery(sqlQuery,headers);

    return true;
  }

  public void create(Stop stop) throws ApplicationException {
    QueryBuilder queryBuilder = this.getInsertInstance()
            .onTable("stop")
            .insertValue("stopid", stop.getStopId())
            .insertValue("stopname", stop.getStopName());

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);
  }

  public boolean areStopsPresent(String startStopName, String endStopName)
          throws ApplicationException {
    return this.isPresent("stop", "stopname", startStopName) &&
            this.isPresent("stop", "stopname", endStopName);
  }
}
