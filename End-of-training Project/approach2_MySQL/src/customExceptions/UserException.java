package customExceptions;

/**
 * The class UserException is a Custom Exceptions class which extends the Java Exception class.
 * It is used to catch exceptions related to User inputs such as InputMismatchException, invalid
 * inputs for a field, etc. and throw a custom message which is understandable by the user.
 * UserExceptions are caught in the Upper Layer/Operations package, and are shown to user if they
 * have entered any invalid inputs.
 * The Exceptions are from User Perspective.
 **/

public class UserException extends Exception {

  public UserException(String message) {
    super(message);
  }
}