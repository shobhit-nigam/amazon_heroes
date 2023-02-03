package queryHelper;

/**
 * The class GroupByClause holds column value for the group by operation in a sql query.
 * It is used by QueryBuilder class to build sqlQueries
 * **/

public class GroupByClause {

  public String columnName;

  GroupByClause(String columnName) {
    this.columnName = columnName;

  }

  public String getGroupByQuery() {
    return this.columnName;
  }
}