package queryHelper;

/**
 * The class WhereOperation holds key-value pair for the sql operations in which 'where' keyword is
 * used.
 * It is used by QueryBuilder class to build sqlQueries
 * **/

class WhereOperation {

  // Variables store the Operation(=,<,>,etc), key(columnName), type(integer, boolean, etc.) & value
  public String op;
  public String key;
  public String type;
  public String value;

  // Sets the value for each variable for an instance
  WhereOperation(String op, String key, int intVal) {
    this.op = op;
    this.key = key;
    this.type = "integer";
    this.value = intVal + "";
  }

  WhereOperation(String op, String key, String strVal) {
    this.op = op;
    this.key = key;
    this.type = "string";
    this.value = strVal + "";
  }

  // Returns query which is added after WHERE Keyword
  public String getWhereQuery() {
    String value = "";

    if (this.type == "string") {
      value = "\'" + this.value + "\'";
    } else if (this.type == "integer") {
      value = this.value + "";
    }
    String operation = "";

    if (this.op == "eq") {
      operation = "=";
    } else if (this.op == "lte") {
      operation = "<=";
    } else if (this.op == "gte") {
      operation = ">=";
    } else if (this.op == "gt") {
      operation = ">";
    } else if (this.op == "lt") {
      operation = "<";
    } else if (this.op == "neq") {
      operation = "<>";
    }

    return this.key + " " + operation + " " + value;
  }
}

