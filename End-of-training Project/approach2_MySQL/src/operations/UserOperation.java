package operations;

import assets.AssetFactory;
import assets.BusPass;
import assets.Feedback;
import assets.RouteRequest;
import customExceptions.ApplicationException;
import customExceptions.UserException;
import dbTools.TimeConverter;
import managers.BusManager;
import managers.BusPassManager;
import managers.FeedbackManager;
import managers.RouteManager;
import managers.RouteRequestManager;
import managers.SeatManager;
import managers.StopManager;
import managers.UserManager;

/**
 * The class UserOperation is a child class of BaseOperation.
 * This Upper Layer class implements the Operations functionality for the Users. It is an extension
 * of BaseOperation class.
 * It utilises Middle Layer/managers package and helper classes/ functions to send db operation
 * requests such as validate, create, read, etc.
 * It contains functions related to features which can be used by the User.
 * It does not interact with Lower Layer/dbTools package but interacts with middle layers
 * via the parent - baseOperation and the User via the console.
 * All user actions happen through this class, after a successful login.
 * It catches UserExceptions via the parent BaseOperation, and shows them to the user for their
 * understanding.
 **/

public class UserOperation extends BaseOperation {

  public boolean showMenu(int userId) throws ApplicationException {

    boolean exitCode = false;
    String choice = "";

    while (!exitCode) {
      System.out.println("\nWelcome to the User Operations Menu");
      System.out.println("\nPlease Select an Option : ");

      System.out.println("\n1. View Available Routes\n" +
              "2. Update Profile\n" +
              "3. Raise Request For a New Route \n" +
              "4. Raise Request for a Bus Pass\n" +
              "5. Provide Feedback\n" +
              "0. Exit to Main Menu\n");
      choice = OperationFactory.getScannerInstance().next();

      switch (choice) {
        case "1":
          displayBusTimingsAndRoutes();
          break;
        case "2":
          updateProfile(userId);
          break;
        case "3":
          try {
            requestNewRoute(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;
        case "4":
          try {
            requestBusPass(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;
        case "5":
          try {
            provideFeedback(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;
        case "0":
          exitCode = true;
          break;

        default:
          System.out.println("Please Enter Valid Option\n");
      }
    }

    System.out.println("Returning to Previous Menu");

    return true;
  }

  private void displayBusTimingsAndRoutes() throws ApplicationException {
    System.out.println("\nBelow is information on Start Timings and Routes which have Active " +
            "and Available Buses :\n");

    BusManager.getInstance().displayAvailableBusTimingsAndRoutes();
  }

  private boolean updateProfile(int userId) throws ApplicationException {
    boolean exCode = false;
    String choice = "";

    while (!exCode) {
      System.out.println("\nSelect Field to Update\n");

      System.out.println("1. Name \n" +
              "2. E-mail address\n" +
              "3. Contact Number\n" +
              "4. Emergency Contact Details\n" +
              "5. Blood Group\n" +
              "6. Password\n" +
              "0. Return to User Menu");

      choice = OperationFactory.getScannerInstance().next();

      if (!choice.equalsIgnoreCase("0")) {
        System.out.println("Please enter values below : ");
      }

      switch (choice) {
        case "1":
          try {
            updateName(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "2":
          try {
            updateEmail(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "3":
          try {
            updateContactNo(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "4":
          try {
            updateEmergencyContact(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "5":
          try {
            updateBloodGroup(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "6":
          try {
            updatePassword(userId);
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "0":
          exCode = true;
          break;

        default:
          System.out.println("Please Enter Valid Option\n");
      }

    }
    System.out.println("Returning to User Menu");

    return true;
  }

  private boolean updatePassword(int userId) throws UserException, ApplicationException {
    System.out.println("Existing Password :\n");
    String oldPassword = this.getExistingPassword(userId);

    System.out.println("Enter New Password :\n" +
            "[Should be of at least 8 characters, contain only letters and digits and " +
            "must contain at least 2 digits]");
    String newPassword = this.getPassword();

    if (this.arePasswordsMatching(oldPassword, newPassword)) {
      System.out.println("New Password is the same as Current password.");
      return false;
    }

    System.out.println("Enter New Password Again :\n");
    String newConfirmedPassword = this.getConfirmedPassword(newPassword);

    UserManager.getInstance().update(userId, "password", newConfirmedPassword);

    System.out.println("Your password has been updated. Hereafter, you must log-in using your new " +
            "password\n");

    return true;
  }

  private boolean updateBloodGroup(int userId) throws UserException, ApplicationException {
    System.out.println("Blood Group [Format : APOSITIVE, ABNEGATIVE,etc.] :\n");
    String bloodGroup = this.getBloodGroup();

    UserManager
            .getInstance()
            .update(userId, "bloodgroup", bloodGroup);

    System.out.println("\nBlood Group has been updated to : " + bloodGroup);

    return true;
  }

  private boolean updateEmergencyContact(int userId) throws UserException, ApplicationException {
    System.out.println("Emergency Contact Name : \n");
    String emergencyContactName = this.getFullName();

    System.out.println("Emergency Contact Number[Only 10 digits or 12 digits with country code] : \n");
    String emergencyContactNumber = this.getContactNo();

    UserManager
            .getInstance()
            .update(userId, "emergencycontactname", emergencyContactName);
    UserManager
            .getInstance()
            .update(userId, "emergencycontactno", emergencyContactNumber);

    System.out.println("Emergency Contact Details has been updated to :\n"
            + emergencyContactName + " with Phone No. : " + emergencyContactNumber);

    return true;
  }

  private boolean updateContactNo(int userId) throws UserException, ApplicationException {
    System.out.println("\nContact Number[Only 10 digits or 12 digits with country code] :");
    String contactNumber = this.getContactNo();

    UserManager
            .getInstance()
            .update(userId, "contactno", contactNumber);

    System.out.println("Your Contact Number has been Updated to : " + contactNumber);

    return true;
  }

  private boolean updateEmail(int userId) throws UserException, ApplicationException {
    System.out.println("E-mail Address :\n");
    String email = this.getEmail();

    UserManager
            .getInstance()
            .update(userId, "email", email);

    System.out.println("Your contact E-mail address has been Updated to : " + email);

    return true;
  }

  private void updateName(int userId) throws UserException, ApplicationException {
    System.out.println("First Name :\n");
    String firstName = this.getFirstName();

    System.out.println("Last Name :\n");
    String lastName = this.getLastName();

    UserManager
            .getInstance()
            .update(userId, "fname", firstName);
    UserManager
            .getInstance()
            .update(userId, "lname", lastName);

    System.out.println("You Name has been updated to : " + firstName + " " + lastName);
  }

  /**Validates if requested stops are under a route with selected timing.
   * if route(s) with selected timing and stops exist(s), then displays the information
   * if such a route does not exist, creates a route request record in table.
   */
  private boolean requestNewRoute(int userId) throws ApplicationException, UserException {
    System.out.println("\nFor Your Reference, below are stops which are currently supported :\n");

    StopManager
            .getInstance()
            .displayAllStops();

    System.out.println("\n[If your stop is listed above, make sure that you enter Stop Name with " +
            "the same spelling.}\n[If not, you may proceed to request the required new stops]\n");

    System.out.println("Enter Details Below: ");

    System.out.println("\nStart Stop Name :");
    String startStopName = this.getStopName();

    System.out.println("\nEnd Stop Name :");
    String endStopName = this.getStopName();

    System.out.println("\nStart Timing [in 24 hour format separated by : Or / or -]:");
    String timingString = this.getTimeString();

    int timeInMinutes = TimeConverter
            .getTimeAsMinutes(timingString);

    boolean routeExists = true;

    int startStopId = 0;
    int endStopId = 0;

    boolean stopsExist = StopManager
            .getInstance()
            .areStopsPresent(startStopName, endStopName);

    if (stopsExist) {
      startStopId = StopManager
              .getInstance()
              .getStopIdForName(startStopName);

      endStopId = StopManager
              .getInstance()
              .getStopIdForName(endStopName);

      routeExists = RouteManager
              .getInstance()
              .getAvailableBuses(startStopId, endStopId, timeInMinutes);

      if (routeExists) {
        return false;
      }
    }

    RouteRequest routeRequest;

    if (stopsExist) {
      routeRequest = AssetFactory
              .getInstance()
              .getRouteRequestInstance(startStopId, endStopId, userId, routeExists, timeInMinutes);
    } else {
      routeRequest = AssetFactory
              .getInstance()
              .getRouteRequestInstance(startStopName, endStopName, userId, routeExists, timeInMinutes);
    }

    RouteRequestManager.getInstance().create(routeRequest);

    System.out.println("\nYour Route Request has been sent, as per the below details :\n" +
            "====> START STOP : " + startStopName + "\t\tEND STOP: " + endStopName + "\t\t" +
            "START TIMING : " + timingString + " <====");

    return true;
  }

  // Creates a BusPass for User
  private boolean requestBusPass(int userId) throws ApplicationException, UserException {
    if (BusPassManager.getInstance().isValidBusPass(userId)) {
      System.out.println("BusPass for " + userId + " already exists\n");

      return false;
    }

    System.out.println("For your reference,");
    displayBusTimingsAndRoutes();

    System.out.println("\nEnter Route Id");
    int routeId = this.getRouteId();

    if(!RouteManager
            .getInstance()
            .isPresent("route","routeid",routeId)) {
      System.out.println("\nProvided Route ID does not exist. " +
              "Please refer to the available schedule before entering the value.");

      return false;
    }

    System.out.println("Start Timing [in 24 hour format separated by : Or / or -]:\n");
    String timeString = this.getTimeString();

    int timeInMinutes = TimeConverter
            .getTimeAsMinutes(timeString);

    if (SeatManager
            .getInstance()
            .updateBusPassWithAvailability(routeId, timeInMinutes) == 0) {
      System.out.println("No Seats or Active Bus Available for the provided route and" +
              " the preferred time");

      return false;
    }

    int busId = SeatManager
            .getInstance()
            .updateBusPassWithAvailability(routeId, timeInMinutes);

    BusPass busPass = AssetFactory
            .getInstance()
            .getBusPassInstance(userId,routeId,busId,timeInMinutes);

    BusPassManager.getInstance().create(busPass);

    System.out.println("Bus Pass Allocated with Bus Pass ID : " + busPass.getBusPassId());

    return true;
  }

  // Creates a Feedback record for the user comment
  private boolean provideFeedback(int userId) throws ApplicationException, UserException {
    System.out.println("Enter Your Valuable Feedback below [Word Limit 100]\n " +
            "To return to previous menu, press 'Enter' twice\n");
    String comment = this.getComment();

    Feedback feedback = AssetFactory
            .getInstance()
            .getFeedbackInstance(userId, comment);

    FeedbackManager
            .getInstance()
            .create(feedback);

    System.out.println("The below Feedback has been recorded : \n" + comment);
    System.out.println("\n----------Thank You for Your Valuable Feedback------------\n");

    return true;
  }
}
