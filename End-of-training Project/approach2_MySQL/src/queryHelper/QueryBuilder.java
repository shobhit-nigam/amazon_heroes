package queryHelper;

import java.util.ArrayList;

/**
 * The class QueryBuilder is a Helper Class and Builder Implementation.
 * Here, multiple states are defined for each SQL operations.
 * Method Chaining is used by functions which utilize this class, to create sql queries.
 * For each state instance, QueryBuilder returns its own object so that method chaining can be achieved
 * and each part of the query is build based on its attributes.
 * It utilises list of OperationKV , GroupBy and Where class instances to alter its state and build a
 * sql string.
 * **/
public class QueryBuilder {

  // Constants to store Object's state
  private static final String INSERT = "INSERT";
  private static final String SELECT = "SELECT";
  private static final String UPDATE = "UPDATE";
  private static final String DELETE = "DELETE";

  private String state;
  private String[] columns;
  private String table;

  // Saves List of Where and Operation Key Value Pairs
  private ArrayList<WhereOperation> whereOperations;
  private ArrayList<OperationKV> operationKVs;
  private ArrayList<GroupByClause> groupByClauses;

  private boolean isSelectAllColumns;


  public static QueryBuilder getInstance() {

    return new QueryBuilder();
  }

  public QueryBuilder() {
    this.isSelectAllColumns = false;
    this.whereOperations = new ArrayList<WhereOperation>();
    this.operationKVs = new ArrayList<OperationKV>();
    this.groupByClauses = new ArrayList<GroupByClause>();
  }

  private void checkState() throws Exception {
    if (this.state != null) {
      throw new Exception("State already set");
    }
  }

  // Sets the State of Current Object after Instantiation
  public QueryBuilder select() throws Exception {
    this.checkState();
    this.state = SELECT;
    return this;
  }

  public QueryBuilder insert() throws Exception {
    this.checkState();
    this.state = INSERT;
    return this;
  }

  public QueryBuilder update() throws Exception {
    this.checkState();
    this.state = UPDATE;
    return this;
  }

  public QueryBuilder delete() throws Exception {
    this.checkState();
    this.state = DELETE;
    return this;
  }

  // keeps the column names to be added in a select state object
  public QueryBuilder selectColumns(String[] columns) {
    this.columns = columns;
    return this;
  }

  public QueryBuilder selectColumns(String column) {
    this.columns = new String[]{column};
    return this;
  }

  public QueryBuilder selectAllColumns() {
    this.isSelectAllColumns = true;
    return this;
  }

  // Adds the Key-Value pairs for WhereOperation
  public QueryBuilder whereEq(String key, int val) {
    this.whereOperations.add(new WhereOperation("eq", key, val));
    return this;
  }

  public QueryBuilder whereEq(String key, String val) {
    this.whereOperations.add(new WhereOperation("eq", key, val));
    return this;
  }

  public QueryBuilder whereLte(String key, String val) {
    this.whereOperations.add(new WhereOperation("lte", key, val));
    return this;
  }

  public QueryBuilder whereGte(String key, int val) {
    this.whereOperations.add(new WhereOperation("gte", key, val));
    return this;
  }

  public QueryBuilder whereLt(String key, int val) {
    this.whereOperations.add(new WhereOperation("lt", key, val));
    return this;
  }

  public QueryBuilder whereGt(String key, int val) {
    this.whereOperations.add(new WhereOperation("gt", key, val));
    return this;
  }

  public QueryBuilder whereNeq(String key, int val) {
    this.whereOperations.add(new WhereOperation("neq", key, val));
    return this;
  }

  public QueryBuilder whereNeq(String key, String val) {
    this.whereOperations.add(new WhereOperation("neq", key, val));
    return this;
  }

  // Group By
  public QueryBuilder groupBy(String column) {
      this.groupByClauses.add(new GroupByClause(column));
    return this;
  }

  // Adds the Key-Value pairs for InsertOperation
  public QueryBuilder insertValue(String key, int val) {
    this.operationKVs.add(new OperationKV(key, val));
    return this;
  }

  public QueryBuilder insertValue(String key, String val) {
    this.operationKVs.add(new OperationKV(key, val));
    return this;
  }

  public QueryBuilder insertValue(String key, boolean val) {
    this.operationKVs.add(new OperationKV(key, val));
    return this;
  }

  // Adds the Key-Value pairs for UpdateOperation
  public QueryBuilder updateValue(String key, String val) {
    this.insertValue(key, val);
    return this;
  }

  public QueryBuilder updateValue(String key, int val) {
    this.insertValue(key, val);
    return this;
  }

  // Sets the table on which query will act on
  public QueryBuilder onTable(String table) {
    this.table = table;
    return this;
  }

  // Returns the query based on state
  public String build() throws Exception {
    switch (this.state) {
      case QueryBuilder.SELECT:
        return this.buildSelect();
      case QueryBuilder.INSERT:
        return this.buildInsert();
      case QueryBuilder.UPDATE:
        return this.buildUpdate();
      case QueryBuilder.DELETE:
        return this.buildDelete();
    }
    return "";
  }

  // Builds the query for Delete
  private String buildDelete() {
    String query = "DELETE from " + this.table;

    if (this.whereOperations.size() > 0) {
      query += " WHERE ";

      if (this.whereOperations.size() == 1) {
        query += this.whereOperations.get(0).getWhereQuery() + " ";
      } else {
        for (int i = 0; i < this.whereOperations.size(); i++) {
          query += this.whereOperations.get(i).getWhereQuery() + " ";

          if (i != this.whereOperations.size() - 1) {
            query += "AND ";
          }
        }
      }
    }

    query += ";";

    return query;
  }

  // Builds the query for Select
  private String buildSelect() {
    String query = "SELECT ";

    if (this.isSelectAllColumns) {
      query += " * ";
    } else {
      for (int i = 0; i < this.columns.length; i++) {
        query += this.columns[i] + (i < this.columns.length - 1 ? ", " : "");
      }
    }

    query += " FROM " + this.table;

    if (this.whereOperations.size() > 0) {
      query += " WHERE ";

      if (this.whereOperations.size() == 1) {
        query += this.whereOperations.get(0).getWhereQuery() + " ";
      } else {
        for (int i = 0; i < this.whereOperations.size(); i++) {
          query += this.whereOperations.get(i).getWhereQuery() + " ";

          if (i != this.whereOperations.size() - 1) {
            query += "AND ";
          }
        }
      }
    }

    if(this.groupByClauses.size()>0) {
      query=query+" GROUP BY ";

      if (this.groupByClauses.size() == 1) {
        query=query+this.groupByClauses.get(0).getGroupByQuery();
      }else {
        for(int i=0;i<this.groupByClauses.size();i++)
        {
          if(i == this.groupByClauses.size()-1)
          {
            query+=this.groupByClauses.get(i).getGroupByQuery();
          }else {
            query+=this.groupByClauses.get(i).getGroupByQuery()+", ";

          }
        }
      }
    }
    query += ";";

    return query;
  }

  // Builds the query for Insert
  private String buildInsert() throws Exception {
    String query = "INSERT INTO " + this.table + " ";

    if (this.operationKVs.size() == 0) {
      throw new Exception("Nothing to insert");
    }

    String values = "";
    String actualVals = "";

    for (int i = 0; i < operationKVs.size(); i++) {
      OperationKV operation = operationKVs.get(i);
      values += operation.key;
      actualVals += operation.type == "string" ? "\'" + operation.value + "\'" : operation.value;

      if (i != operationKVs.size() - 1) {
        values += ",";
        actualVals += ",";
      }
    }

    query += "(" + values + ")";
    query += " VALUES (" + actualVals + " )";
    query += ";";
    return query;
  }

  // Builds the query for Update
  private String buildUpdate() throws Exception {
    String query = "UPDATE " + this.table + " ";

    String sets = "";

    if (this.operationKVs.size() == 0) {
      throw new Exception("No update");
    }

    for (int i = 0; i < this.operationKVs.size(); i++) {
      sets += this.operationKVs.get(i).getAssignmentQuery();

      if (i != this.operationKVs.size() - 1) {
        sets += " , ";
      }
    }

    if (this.whereOperations.size() == 0) {
      throw new Exception("No where");
    }

    String wheres = "";

    for (int i = 0; i < this.whereOperations.size(); i++) {
      wheres += this.whereOperations.get(i).getWhereQuery();

      if (i != this.whereOperations.size() - 1) {
        wheres += " AND ";
      }
    }

    query += " SET " + sets + " WHERE " + wheres;
    query += ";";

    return query;
  }
}