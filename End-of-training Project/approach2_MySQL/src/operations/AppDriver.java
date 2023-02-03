package operations;

import customExceptions.ApplicationException;
import java.util.concurrent.TimeUnit;

/* This class is an Outer Layer of the application. which contains the Home Page.
 * It has 4 options :
 * 1. Admin --> takes to Admin LogIn
 * 2. User --> takes to User LogIn
 * 3. Visitor --> takes to user operation
 * 0. Exit --> exits out of the application
 *
 * Also, it uses time delay to simulate animation for the loading screen of the application.
 * */

public class AppDriver {
  public void initiate()  {
    boolean exitCode = false;

    while (!exitCode) {
      System.out.println("_______________________________________________________________");
      System.out.println("|`Welcome to Amazon's Employee BusPass Management Application`|");
      loadScreen();
      System.out.println("\nEnter your User Type :");
      System.out.println("\n1. Admin \n2. User\n3. Visitor \n0. Exit \n");

      String choice = OperationFactory.getScannerInstance().next();

      switch (choice) {
        case "1":
          System.out.println("Welcome Administrator!\n");

          try {
            OperationFactory.getAdminLoginInstance().showMenu();
          } catch (ApplicationException e) {
            e.printStackTrace();
          }
          break;

        case "2":
          System.out.println("Welcome User!\n");

          try {
            OperationFactory.getUserLoginInstance().showMenu();
          } catch (ApplicationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
          }
          break;

        case "3":
          System.out.println("Welcome Visitor!\n");

          try {
            OperationFactory.getVisitorOperationInstance().showMenu();
          } catch (ApplicationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
          }
          break;

        case "0":
          exitCode = true;
          break;

        default:
          System.out.println("Please Enter Valid Option");
      }
    }

    System.out.println("Thank You For Using our Employee BusPass Management Application\n");
    loadScreen();
  }

  private void loadScreen(){
    System.out.println("_______________________________________________________________");
    System.out.println("---------------------------------------------------------------");

    int del = 0;
    while(del !=6){
      try {
        TimeUnit.MILLISECONDS.sleep(1000/(del+1*2));
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      int k = del;
      while(k!=0){
        System.out.print("_~`~");
        k--;
      }
      del++;
    }
    System.out.print("_~`~");
    System.out.println("\n---------------------------------------------------------------");
  }
}


















