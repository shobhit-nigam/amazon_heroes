package managers;

import customExceptions.ApplicationException;
import queryHelper.QueryBuilder;

/**
 * The class IdManager is a Singleton implementation which is a single-point provider of unique ids
 * to AssetFactory for instance creation of various classes from asset package.
 * IdManager manages a table - idgenerator - in the db which keeps store of unique latest id
 * for each class. When a new id is requested, the latest id for the requested class is incremented,
 * saved in the table and then returned to AssetFactory for instantiation of classes.
 * This helps to keeping the unique id as a easy-to-use integer value.
 **/

public class IdManager extends BaseManager {

  private static IdManager idManager;

  public static IdManager getInstance() {
    if (idManager == null) {
      idManager = new IdManager();
    }
    return idManager;
  }

  public int getNewId(String objectName) throws ApplicationException {
    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns("latestid")
            .onTable("idgenerator")
            .whereEq("objectname", objectName);

    String sqlQuery = this.buildQuery(queryBuilder);

    int newId = this.getQueryNumber(sqlQuery) + 1;

    queryBuilder = this.getUpdateInstance()
            .onTable("idgenerator")
            .updateValue("latestid", newId)
            .whereEq("objectname", objectName);

    sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);

    return newId;
  }
}