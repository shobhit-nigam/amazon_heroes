package operations;

import assets.Admin;
import customExceptions.ApplicationException;
import customExceptions.UserException;

/**
 * This class is implements the log-in page for Admin
 * Admin can login with their Admin id and password
 *  - If login is successful, they are routed to the Admin Operation page of the application.
 *  - If login is unsuccessful even after 3 tries, they are routed back to the application homepage.
 * **/

// AdminLogin , Singleton as Only 1 ADMIN is Hard-Coded
public class AdminLoginOperation extends BaseOperation {

  // Set Hard-Coded values of ADMIN object to variables
  private String adminID = Admin.getAdminInstance().getAdminId();
  private String password = Admin.getAdminInstance().getPassword();

  private static int loginTries = 1;
  private final static int maxLoginTries = 3;

  private static AdminLoginOperation adminLogin;

  private AdminLoginOperation() { }

  public static AdminLoginOperation getInstance() {
    if(adminLogin == null) {
      adminLogin = new AdminLoginOperation();
    }
    return adminLogin;
  }

  public void showMenu() throws ApplicationException {
    try {
      setLoginDetails();
    } catch (UserException e) {
      System.out.println("An issue has occurred. Please retry logging in.");
    }
  }

  private void login(String adminId, String password) throws ApplicationException, UserException {
    if(adminId.trim().equals(this.adminID) && password.equals(this.password)) {
      System.out.println("Admin Login Successful!");
      OperationFactory.getAdminOperationInstance().showMenu();
    } else {
      System.out.println("Please enter correct ID and Password.[Only 3 tries are allowed] \n");
      setLoginDetails();
    }
  }

  // Gets Admin credentials from console
  private boolean setLoginDetails() throws UserException, ApplicationException {
    System.out.println("\n Admin Login ");
    loginTries += 1;

    System.out.println("Enter Login ID : \n");
    String userId = this.getAdminId();

    System.out.println("Enter Password : \n");
    String password = this.getAdminPassword();

    if (loginTries > maxLoginTries) {
      System.out.println("Maximum Login Tries Exceeded! \n Returning to Home.");

      loginTries = 0;

      return false;
    }

    login(userId, password);

    return true;
  }
}
