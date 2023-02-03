package managers;

import assets.User;
import customExceptions.ApplicationException;
import queryHelper.QueryBuilder;

/**
 * The class UserManager is a child class of BaseManager.
 * It works as a middle layer between the dbTools package/Lower Layer and the Operations
 * package/Upper Layer.
 * It contains functions related to User table such as read, create a record, validate data
 * from table, operation specific functions which require db support, etc.
 * It is used by the Upper Layers/Operations classes.
 * It utilizes Lower Layer/dbTools package and helper classes via the parent - BaseManager which
 * converts system exceptions to ApplicationExceptions.
 **/

public class UserManager extends BaseManager {

  private static UserManager userManager;

  public static UserManager getInstance() {
    if (userManager == null) {
      userManager = new UserManager();
    }
    return userManager;
  }

  public void create(User user) throws ApplicationException {
    QueryBuilder queryBuilder = this.getInsertInstance()
            .onTable("user")
            .insertValue("userid", user.getEmployeeId())
            .insertValue("fname", user.getFirstName())
            .insertValue("lname", user.getLastName())
            .insertValue("email", user.getEmail())
            .insertValue("contactno", user.getContactNo())
            .insertValue("emergencycontactno", user.getEmergencyContactNo())
            .insertValue("emergencycontactname", user.getEmergencyContactName())
            .insertValue("bloodgroup", user.getBloodGroup())
            .insertValue("password", user.getPassword());

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);
  }

  public void update(int employeeId, String field, String newValue) throws ApplicationException {
    QueryBuilder queryBuilder = this.getUpdateInstance()
            .updateValue(field, newValue)
            .whereEq("userid", employeeId)
            .onTable("user");
    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);
  }

  public boolean isValidUserPassword(int userId, String password) throws ApplicationException {
    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns("userid")
            .onTable("user")
            .whereEq("userid", userId)
            .whereEq("password", password);

    String sqlQuery = this.buildQuery(queryBuilder);


    return this.hasResult(sqlQuery);
  }

  public boolean isValidUser(int userId) throws ApplicationException {
    QueryBuilder queryBuilder = this.getSelectInstance()
            .selectColumns("userid")
            .onTable("user")
            .whereEq("userid", userId);

    String sqlQuery = this.buildQuery(queryBuilder);

    return this.hasResult(sqlQuery);
  }
}
