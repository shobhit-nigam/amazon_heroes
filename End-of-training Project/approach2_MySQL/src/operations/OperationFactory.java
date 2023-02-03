package operations;

import java.util.Scanner;

/**
 * The class OperationFactory is a Simple Factory implementation which returns new instances for all
 * classes and controls single-point instance creation of the Upper Layer/Operations package.
 * OperationFactory is utilised in the Upper-Layer/Operations package for getting on-the-fly instances
 * of classes under Operations folder which can be used in a single statement.
 **/

public class OperationFactory {

  public static AdminLoginOperation getAdminLoginInstance() {
    return AdminLoginOperation.getInstance();
  }

  public static AdminOperation getAdminOperationInstance() {
    return new AdminOperation();
  }

  public static UserLoginOperation getUserLoginInstance() {
    return new UserLoginOperation();
  }

  public static UserOperation getUserOperationInstance() {
    return new UserOperation();
  }

  public static VisitorOperation getVisitorOperationInstance() {
    return new VisitorOperation();
  }

  public static Scanner getScannerInstance() {
    return new Scanner(System.in).useDelimiter("\n");
  }
}
