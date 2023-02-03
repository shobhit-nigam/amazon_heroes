package managers;

import assets.BusPass;
import customExceptions.ApplicationException;
import queryHelper.QueryBuilder;

/**
 * The class BusPassManager is a child class of BaseManager.
 * It works as a middle layer between the dbTools package/Lower Layer and the Operations
 * package/Upper Layer.
 * It contains functions related to BusPass table such as read, create a record, validate data
 * from table, operation specific functions which require db support, etc.
 * It is used by the Upper Layers/Operations classes.
 * It utilizes Lower Layer/dbTools package and helper classes via the parent - BaseManager which
 * converts system exceptions to ApplicationExceptions.
 **/

public class BusPassManager extends BaseManager {

  private static BusPassManager busPassManager;

  public static BusPassManager getInstance() {
    if (busPassManager == null) {
      busPassManager = new BusPassManager();
    }
    return busPassManager;
  }

  public void create(BusPass busPass) throws ApplicationException {
    QueryBuilder queryBuilder = this.getInsertInstance()
            .onTable("buspass")
            .insertValue("buspassid", busPass.getBusPassId())
            .insertValue("userid", busPass.getUserId())
            .insertValue("busid", busPass.getBusId())
            .insertValue("routeid", busPass.getRouteId())
            .insertValue("timing", busPass.getTiming());

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);
  }

  public boolean isValidBusPass(int userId) throws ApplicationException {
    return this.isPresent("buspass", "userid", userId);
  }
}
