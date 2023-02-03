package operations;

import assets.AssetFactory;
import assets.Bus;
import assets.Route;
import assets.Stop;
import customExceptions.ApplicationException;
import customExceptions.UserException;
import dbTools.TimeConverter;
import java.util.ArrayList;
import java.util.List;
import managers.BusManager;
import managers.RouteManager;
import managers.SeatManager;
import managers.StopManager;

/**
 * The class AdminOperation is a child class of BaseOperation.
 * This Upper Layer class implements the Operations functionality for the Admin. It is an extension
 * of BaseOperation class.
 * It utilises Middle Layer/managers package and helper classes/ functions to send db operation
 * requests such as validate, create, read, etc.
 * It contains functions related to features which can be used by the Admin.
 * It does not interact with Lower Layer/dbTools package but interacts with middle layers
 * via the parent - baseOperation and the Admin via the console.
 * All Admin actions happen through this class, after a successful login.
 * It catches UserExceptions via the parent BaseOperation, and shows them to the Admin user for their
 * understanding.
 **/

public class AdminOperation extends BaseOperation {

  public boolean showMenu() throws ApplicationException {
    boolean exitCode = false;
    String choice = "";

    while (!exitCode) {
      System.out.println("\nWelcome to the Admin Operations Menu");
      System.out.println("\nPlease Select an Option : ");

      System.out.println("\n1. Bus Control Menu\n" +
              "2. Route Control Menu\n" +
              "3. Change Bus & Route Assignments\n" +
              "4. Change Type of a Bus\n" +
              "5. Display Number of Buses of each Type\n" +
              "6. Display timings and route for each bus\n" +
              "0. Exit to Main Menu");

      choice = OperationFactory.getScannerInstance().next();

      switch (choice) {
        case "1":
          busControlMenu();
          break;

        case "2":
          routeControlMenu();
          break;

        case "3":
          try {
            assignBusToRoute();
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "4":
          changeBusTypeMenu();
          break;

        case "5":
          displayBusCountOfEachType();
          break;

        case "6":
          displayBusTimingsAndRoutes();
          break;

        case "0":
          exitCode = true;
          break;

        default:
          System.out.println("Please Enter Valid Option\n");
      }
    }

    System.out.println("Returning to previous Menu");

    return true;
  }

  private boolean routeControlMenu() throws ApplicationException {
    boolean exitCode = false;
    String choice = "";

    while (!exitCode) {
      System.out.println("\nWelcome to the Route Control Menu");
      System.out.println("\nPlease Select an Option : \n");

      System.out.println("1. Add a New Route\n" +
              "2. Remove an Existing Route\n" +
              "3. Add a new Stop\n" +
              "4. View all routes with their stops \n" +
              "0. Return to Admin Menu\n");

      choice = OperationFactory.getScannerInstance().next();

      switch (choice) {

        case "1":
          try {
            addRoute();
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "2":
          try {
            removeRoute();
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "3":
          try {
            addStop();
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "4":
          displayOnlyRoutes();
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

  private boolean busControlMenu() throws ApplicationException {

    boolean exitCode = false;
    String choice = "";

    while (!exitCode) {
      System.out.println("\nWelcome to the Bus Control Menu");
      System.out.println("\nPlease Select an Option : ");

      System.out.println("\n1. Add a New Bus\n" +
              "2. Remove an Existing Bus\n" +
              "3. Show all Buses\n" +
              "0. Return to Admin Menu\n");

      choice = OperationFactory
              .getScannerInstance()
              .next();

      switch (choice) {
        case "1":
          try {
            addBus();
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "2":
          try {
            removeBus();
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "3":
          displayOnlyBuses();
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

  private boolean changeBusTypeMenu() throws ApplicationException {

    boolean exitCode = false;
    String choice = "";

    while (!exitCode) {
      System.out.println("\nWelcome to the Change Bus Type Menu");
      System.out.println("\nPlease Select an Option : ");

      System.out.println("\n1. Change Type of an Active Bus [Already has a Route assigned]\n" +
              "2. Change Type of an Inactive Bus [Does Not have Route assigned]\n" +
              "3. Show all Buses\n" +
              "0. Return to Admin Menu\n");

      choice = OperationFactory
              .getScannerInstance()
              .next();

      switch (choice) {
        case "1":
          try {
            changeActiveBusType();
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "2":
          try {
            changeInactiveBusType();
          } catch (UserException e) {
            this.printMenuException(e);
          }
          break;

        case "3":
          displayOnlyBuses();
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

  private void displayOnlyRoutes() throws ApplicationException {
    System.out.println("\nBelow is the master list of all routes :\n");

    RouteManager
            .getInstance()
            .displayAllRoutes();
  }

  private void displayOnlyBuses() throws ApplicationException {
    System.out.println("Below is the list of all Buses in current fleet :\n" +
            "[TIMING : Displayed in Minutes]\n" +
            "[TIMING = -1 : No start timing assigned to Bus]\n" +
            "[ROUTE ID = 0 : No route assigned to Bus]\n");

    BusManager
            .getInstance()
            .displayAllBuses();
  }

  private boolean addStop() throws UserException, ApplicationException {

    System.out.println("\nCurrently, supported stops : \n");
    StopManager
            .getInstance()
            .displayAllStops();

    System.out.println("\nPlease provide a Stop Name to add : \n");
    String stopName = this.getStopName();

    Stop newStop = AssetFactory
            .getInstance()
            .getStopInstance(stopName);

    StopManager
            .getInstance()
            .create(newStop);

    System.out.println("\nUpdated List of Stops:");
    StopManager
            .getInstance()
            .displayAllStops();

    return true;
  }

  private boolean changeActiveBusType() throws ApplicationException, UserException {

    System.out.println("For your reference,");
    displayOnlyBuses();

    System.out.println("\nEnter Route Id");
    int routeId = this.getRouteId();

    if (!BusManager
            .getInstance()
            .isPresent("bus", "routeid", routeId)) {
      System.out.println("\nRoute Not Linked to any Bus Or, Route does not Exist");
      return false;
    }

    System.out.println("Enter Bus Id");
    int busId = this.getBusId();

    if(!BusManager.getInstance().hasRoute(routeId,busId)) {
      System.out.println("Entered Bus is not linked to provided Route Or, " +
              "Bus does not have route Or, Bus ID is Invalid");
      return false;
    }

    return this.changeBusType(busId);
  }

  private boolean changeInactiveBusType() throws UserException, ApplicationException {
    System.out.println("For your reference,");
    displayOnlyBuses();
    System.out.println("\nEnter Bus Id");
    int busId = this.getBusId();

    if(!BusManager.getInstance().hasNoRoute(busId)) {
      System.out.println("Entered Bus ID is Active and has an assigned Route. " +
              "\nTo change type of active buses, select option-1 ");
      return false;
    }

    return changeBusType(busId);
  }

  private boolean changeBusType(int busId) throws ApplicationException, UserException {
    if (!BusManager
            .getInstance()
            .isPresent("bus", "busid", busId)) {
      System.out.println("Bus Not Found");

      return false;
    }

    System.out.println("Enter BusType [Number Of Seats]");
    int busType = this.getBusType();

    System.out.println("Enter Vehicle No");
    String vehicleNo = this.getVehicleNo();

    if(BusManager.getInstance().isVehicleNoSame(busId,vehicleNo)) {
      System.out.println("This Vehicle No. is already assigned for the Bus." +
              "\nType change not supported for the same Vehicle No.");
      return false;

    }

    if(BusManager.getInstance().isVehicleNoPresentWithOther(busId,vehicleNo)) {
      System.out.println("This Vehicle No. is already assigned to a different bus." +
              "\nSame Vehicle No. cannot be linked multiple Buses");
      return false;
    }

    if(!SeatManager
            .getInstance()
            .updateBusTypeWithAvailability(busType, busId, vehicleNo)) {
      System.out.println("Bus Type cannot be changed as the value cannot support currently " +
              "occupied seats");
      return false;
    }

    System.out.println("Bus Type and Vehicle Number Updated!\nFor your reference :\n ");
    displayOnlyBuses();

    return true;
  }

  // create a Bus object by taking details from Console
  private boolean addBus() throws ApplicationException, UserException {
    System.out.println("\nPlease Enter New Bus Details Below :");

    System.out.println("\nVehicle Number:");
    String vehicleNo = this.getVehicleNo();

    if (BusManager
            .getInstance()
            .isPresent("bus", "vehicleno", vehicleNo)) {
      System.out.println("\nVehicle already Assigned to different BusId ");

      return false;
    }

    System.out.println("\nBus Type [Capacity/Number of Seats]\n");
    int busType = this.getBusType();

    Bus newBus = AssetFactory.getInstance().getBusInstance(busType, busType, vehicleNo);

    BusManager.getInstance().create(newBus);

    System.out.println("\nYour new Bus with the below details has been created:");
    System.out.println("\nBus ID: " + newBus.getBusId() +
            " Bus Type: " + newBus.getBusType()
            + " Vehicle No: " + newBus.getVehicleNo());

    return true;
  }

  // Checks if Bus Id exists or not. If yes removed it, else returns to main menu
  private boolean removeBus() throws ApplicationException, UserException {
    System.out.println("For your reference,");
    displayOnlyBuses();

    System.out.println("\nPlease enter Bus Id to remove : \n");
    int busIdToRemove = this.getBusId();

    if (!BusManager
            .getInstance()
            .isPresent("bus", "busid", busIdToRemove)) {
      System.out.println("Invalid Bus ID Entered ===>" + busIdToRemove + "<=== " +
              "\nReturning to Previous Menu\n");

      return false;
    }

    BusManager.getInstance().delete(busIdToRemove);

    System.out.println("\nUpdated Bus Fleet : \n");
    BusManager.getInstance().displayAllBuses();

    System.out.println("\nBus with ID : " + busIdToRemove + " has been removed!\n");

    return true;
  }

  // Takes StopNames, validates them and creates Route record.
  private boolean addRoute() throws ApplicationException, UserException {
    System.out.println("Pleas Enter New Route Details below :");

    System.out.println("Number of Stops:\n");
    int stopCount = this.getStopCount();

    System.out.println("\nFor Your Reference, below are stops which are currently supported :\n" +
            "[To add new stop names you may go to the previous menu]\n");

    StopManager
            .getInstance()
            .displayAllStops();

    System.out.println("Stops [From Start Stop to End Stop]\n" +
            "You may press Enter twice to return to previous menu\n");

    int[] stopIds = new int[stopCount];
    int[] stopRanks = new int[stopCount];

    List<Integer> checkStopsList = new ArrayList<Integer>();

    int count = 0;
    int stopId;

    while (count < stopCount) {
      System.out.println("Enter Stop ID No." + (count + 1) + " :");

      stopId = this.getStopId();

      if (StopManager
              .getInstance()
              .isPresent("stop", "stopid", stopId)
              && !checkStopsList.contains(stopId)) {
        checkStopsList.add(stopId);

        stopIds[count] = stopId;
        stopRanks[count] = count + 1;
        ++count;
      } else {
        System.out.println("Stop ID does not exist or has been entered before.\n " +
                "Please enter Valid Stop ID\n" +
                "You may press Enter twice to return to previous menu and add new stop name\n");
      }
    }

    Route newRoute = AssetFactory.getInstance().getRouteInstance(stopIds, stopRanks);
    RouteManager.getInstance().create(newRoute);

    System.out.println("\nNew Route with Route ID : " + newRoute.getRouteId() + " has been created\n");

    System.out.println("Updated list of Routes :");
    RouteManager.getInstance().displayAllRoutes();

    return true;
  }

  // Checks if Route Id exists or not. If yes, remove route from route table
  private boolean removeRoute() throws ApplicationException, UserException {
    System.out.println("For your reference,");
    displayOnlyRoutes();

    System.out.println("Please enter Route Id to remove : \n");
    int routeIdToRemove = this.getRouteId();

    if (!RouteManager.getInstance().isPresent("route", "routeid", routeIdToRemove)) {
      System.out.println("Invalid Route ID entered \nReturning to previous Menu");

      return false;
    }

    BusManager.getInstance().clearRouteAssignments(routeIdToRemove);
    RouteManager.getInstance().delete(routeIdToRemove);

    System.out.println("Route : " + routeIdToRemove + " has been removed from Route List!\n" +
            "All assignments of this Route to Buses have been cleared.");

    System.out.println("Updated list of Routes :");
    RouteManager.getInstance().displayAllRoutes();

    return true;
  }

  // Takes a RouteId, Start Timing  and adds it to the Bus table
  private boolean assignBusToRoute() throws ApplicationException, UserException {
    System.out.println("\nFor Your Reference, below are buses present in current fleet :\n" +
            "[TIMING : Displayed in Minutes]\n" +
            "[TIMING = -1 : No start timing assigned to Bus]\n" +
            "[ROUTE ID = 0 : No route assigned to Bus]\n");

    BusManager
            .getInstance()
            .displayAllBuses();

    System.out.println("Enter below details :");

    System.out.println("Bus Id : \n");
    int busId = this.getBusId();

    if (!RouteManager
            .getInstance()
            .isPresent("bus", "busid", busId)) {
      System.out.println("Bus ID not found. You may add a new Bus from Bus Control Menu." +
              "\nReturning to Previous menu");

      return false;
    }

    System.out.println("For your reference, below is the list of all routes");
    RouteManager
            .getInstance()
            .displayAllRoutes();

    System.out.println("Route ID:");
    int routeId = this.getRouteId();

    if (!RouteManager
            .getInstance()
            .isPresent("route", "routeid", routeId)) {
      System.out.println("Route ID not found. You may add a new Route from Route Control Menu." +
              "\nReturning to Previous menu");

      return false;
    }

    System.out.println("Start Timing [in 24 hour format separated by : Or / or -]:\n");
    String timeString = this.getTimeString();

    int timeInMinutes = TimeConverter.getTimeAsMinutes(timeString);

    BusManager
            .getInstance()
            .update(busId, "routeid", routeId);
    BusManager
            .getInstance()
            .update(busId, "timing", timeInMinutes);

    System.out.println("Route : " + routeId + " & timing " + timeString +
            " has Been added for bus : " + busId);

    System.out.println("\nUpdated Buses and Routes : \n");
    BusManager
            .getInstance()
            .displayAllBuses();

    return true;
  }

  // Executes Query to find Bus Type and their count
  private void displayBusCountOfEachType() throws ApplicationException {
    BusManager.getInstance().displayBusCount("bustype");
  }

  private void displayBusTimingsAndRoutes() throws ApplicationException {
    System.out.println("Below is information on Start Timings and Routes which have Active " +
            "and Available Buses");

    BusManager
            .getInstance()
            .displayAvailableBusTimingsAndRoutes();
  }
}
