package customExceptions;

/**
 * The class ApplicationException is a Custom Exceptions class which extends the Java Exception class.
 * It is used to catch system exceptions related to DB operations such as SQLNotFoundException,
 * ClassNotFoundException, etc. and throw a custom message.
 * System exceptions are thrown from the Lower Layer/dbTools package and caught in the Middle Layer
 * /Managers package. From here, these exceptions are thrown towards Upper Layer as
 * ApplicationExceptions with custom messages
 * The Exceptions are from Developer Perspective.
 **/

public class ApplicationException extends Exception {

  public ApplicationException(String message) {
    super(message);
  }
}
