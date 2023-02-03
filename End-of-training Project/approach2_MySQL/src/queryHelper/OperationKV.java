package queryHelper;

/**
 * The class OperationKV holds key-value pair for the Insert and Update operations in a sql query.
 * It is used by QueryBuilder class to build sqlQueries
 * **/

class OperationKV {

  // Variables store the key(columnName), type(integer, boolean, etc.) & value
  public String key;
  public String value;
  public String type;

  //Sets keys and their values based on type
  OperationKV(String key, String value) {
    this.type = "string";
    this.key = key;
    this.value = value;
  }

  OperationKV(String key, int value) {
    this.type = "integer";
    this.key = key;
    this.value = value + "";
  }

  OperationKV(String key, boolean value) {
    this.type = "boolean";
    this.key = key;
    this.value = value + "";
  }

  // Returns string for assignment part of the query
  String getAssignmentQuery() {
    String value = "";

    if (this.type == "string") {
      value = "\'" + this.value + "\'";
    } else if (this.type == "integer") {
      value = this.value;
    } else if(this.type == "boolean") {
      value = this.value;
    }

    return this.key + " = " + value;
  }
}
