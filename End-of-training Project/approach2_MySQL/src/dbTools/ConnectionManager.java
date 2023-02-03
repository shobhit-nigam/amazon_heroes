package dbTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The class ConnectionManager is a Singleton implementation which controls single-point creation of
 * a connection object from a DB.
 * It sends the connection instance to other classes of the Lower Layer/DB Layer/dbTools Package.
 * Only Lower Layer classes interact with this class to get connection instance.
 **/

public class ConnectionManager {

  private static Connection con;

  public ConnectionManager() { }

  public static Connection getConnection() throws SQLException, ClassNotFoundException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buspass_app?serverTimezone=UTC",
              "root", "");
      return con;
    } catch (Exception e) {
      System.out.println("Connection Issue Found");
      e.printStackTrace();
      throw e;
    }
  }
}

