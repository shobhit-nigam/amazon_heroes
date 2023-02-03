package managers;

import customExceptions.ApplicationException;
import dbTools.QueryExecutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import queryHelper.QueryBuilder;

/**
 * The class BaseManager is a parent class for multiple Manager Classes in managers package.
 * It works as a gateway between the managers package/Middle Layer and the dbTools
 * package/Lower Layer.
 * It provides an middle-layer exception enclosure around common functions being used by the child
 * classes.
 * The child classes interact with the db layer, multiple helpers and users via these functions,
 * while any exceptions occurring due to user behaviour are thrown as custom Application Exceptions.
 **/

public class BaseManager {

  // Catch Exception for incorrect Manager passed, throws ApplicationException
  public static BaseManager getInstance() throws ApplicationException {
    throw new ApplicationException("Class not implemented");
  }

  // Catch Exceptions for QueryBuilder Update, and throw ApplicationException
  protected QueryBuilder getUpdateInstance() throws ApplicationException {
    try {
      return QueryBuilder
              .getInstance()
              .update();
    } catch (Exception e) {
      throw new ApplicationException("Cannot create Update instance");
    }
  }

  // Catch Exceptions for QueryBuilder Select, and throw ApplicationException
  protected QueryBuilder getSelectInstance() throws ApplicationException {
    try {
      return QueryBuilder
              .getInstance()
              .select();
    } catch (Exception e) {
      throw new ApplicationException("Cannot create Select instance");
    }
  }

  // Catch Exceptions for QueryBuilder Insert, and throw ApplicationException
  protected QueryBuilder getInsertInstance() throws ApplicationException {
    try {
      return QueryBuilder
              .getInstance()
              .insert();
    } catch (Exception e) {
      throw new ApplicationException("Cannot create insert instance");
    }
  }

  // Catch Exceptions for QueryBuilder Delete, and throw ApplicationException
  protected QueryBuilder getDeleteInstance() throws ApplicationException {
    try {
      return QueryBuilder
              .getInstance()
              .delete();
    } catch (Exception e) {
      throw new ApplicationException("Cannot create delete instance");
    }
  }

  // Catch Exceptions for QueryBuilder Build, and throw ApplicationException
  protected String buildQuery(QueryBuilder queryBuilder) throws ApplicationException {
    try {
      return queryBuilder
              .build();
    } catch (Exception e) {
      throw new ApplicationException("Could not build query");
    }
  }

  // Executes an sqlQuery
  protected void executeQuery(String sqlQuery) throws ApplicationException {
    try {
      QueryExecutor
              .getInstance()
              .executeSQL(sqlQuery);
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    } catch (ClassNotFoundException e) {
      throw new ApplicationException("Class not found");
    }
  }

  // Checks whether the sqlQuery has a non-empty result
  protected boolean hasResult(String sqlQuery) throws ApplicationException {
    try {
      return QueryExecutor
              .getInstance()
              .isRecordPresent(sqlQuery);
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    } catch (ClassNotFoundException e) {
      throw new ApplicationException("Class not found");
    }
  }

  // Executes an sqlQuery, and adds fields as the header for each column
  protected void executeQuery(String sqlQuery, String[] fields) throws ApplicationException {
    try {
      QueryExecutor
              .getInstance()
              .executeSQL(sqlQuery, fields);
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    } catch (ClassNotFoundException e) {
      throw new ApplicationException("Class not found");
    }
  }

  // Gets the ResultSet from a sqlQuery
  protected ResultSet getResultSet(String query) throws ApplicationException {
    try {
      return QueryExecutor
              .getInstance()
              .getResultSet(query);
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    } catch (ClassNotFoundException e) {
      throw new ApplicationException("Class not found");
    }
  }

  // Gets the first Integer result from a sqlQuery
  protected int getQueryNumber(String sqlQuery) throws ApplicationException {
    try {
      return QueryExecutor
              .getInstance()
              .getQueryNumber(sqlQuery);
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    } catch (ClassNotFoundException e) {
      throw new ApplicationException("Class not found");
    }
  }

  // Gets next Integer in a ResultSet for given columnIndex
  protected int getInt(ResultSet resultSet, int columnIndex) throws ApplicationException {
    try {
      return resultSet.getInt(columnIndex);
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    }
  }

  // Gets next String in a ResultSet for given columnIndex
  protected String getString(ResultSet resultSet, int columnIndex) throws ApplicationException {
    try {
      return resultSet.getString(columnIndex);
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    }
  }

  public boolean isPresent(String tableName, String field, String value) throws ApplicationException {
    QueryBuilder queryBuilder = this.getSelectInstance();

    queryBuilder
            .selectAllColumns()
            .whereEq(field, value)
            .onTable(tableName);

    String query = this.buildQuery(queryBuilder);

    try {
      return QueryExecutor.getInstance().isRecordPresent(query);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new ApplicationException("Invalid SQL");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      throw new ApplicationException("SQL Class not found");
    }
  }

  public boolean isPresent(String tableName, String field, int value) throws ApplicationException {
    QueryBuilder queryBuilder = this.getSelectInstance();

    queryBuilder
            .selectAllColumns()
            .whereEq(field, value)
            .onTable(tableName);

    String query = this.buildQuery(queryBuilder);

    try {
      return QueryExecutor.getInstance().isRecordPresent(query);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new ApplicationException("Invalid SQL");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      throw new ApplicationException("SQL Class not found");
    }
  }

  //  Checks for next row presence in a ResultSet
  protected boolean isNextPresent(ResultSet resultSet) throws ApplicationException {
    try {
      return resultSet.next();
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    }
  }

  // Moved ResultSet Cursor to previous position
  protected boolean goToPrevious(ResultSet resultSet) throws ApplicationException {
    try {
      return resultSet.previous();
    } catch (SQLException e) {
      throw new ApplicationException("SQL exception");
    }
  }
}
