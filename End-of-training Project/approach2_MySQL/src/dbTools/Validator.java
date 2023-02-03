package dbTools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The class Validator is a helper class which contains functions to validate field and format
 * information. It is used by the Upper Layers.
 **/

public class Validator {

  private static int PASSWORD_LENGTH = 8;

  /**"1. A password must have at least eight characters.\n" +
   "2. A password consists of only letters and digits.\n" +
   "3. A password must contain at least two digits \n" +
   */
  public static boolean isValidPassword(String password) {

    if (password.length() < PASSWORD_LENGTH) {
      return false;
    }

    int charCount = 0;
    int numCount = 0;

    for (int i = 0; i < password.length(); i++) {
      char ch = password.charAt(i);

      if (isNumeric(ch)) {
        numCount++;
      } else if (isAlphabetic(ch)) {
        charCount++;
      } else {
        return false;
      }
    }
    return (charCount >= 2 && numCount >= 2);
  }

  public static boolean isAlphabetic(char ch) {
    ch = Character.toUpperCase(ch);
    return (ch >= 'A' && ch <= 'Z');
  }

  public static boolean isAlphabetic(String stringValue) {
    for(int i = 0; i < stringValue.length(); i++) {
      if(!isAlphabetic(stringValue.charAt(i))) {
        return false;
      }
    }
    return true;
  }


  public static boolean isNumeric(char ch) {
    return (ch >= '0' && ch <= '9');
  }

  public static boolean isNumeric(String stringValue) {
    for(int i = 0; i < stringValue.length(); i++) {
      if(!isNumeric(stringValue.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static boolean isValidComment(String comment) {
    if (comment.length() <= 100 && comment.length() > 1) {
      return true;
    }
    return false;
  }

  public static boolean isCommentBlank(String comment) {
    if (comment.trim().equals("")) {
      return true;
    }
    return false;
  }

  public static boolean isValidEmail(String emailAddress) {
    if (emailAddress == null) {
      return false;
    }

    String emailRegex = "[a-zA-Z.0-9_]+@[a-zA-Z0-9_]+\\.[a-zA-Z]{2,7}$";

    Pattern pat = Pattern.compile(emailRegex);

    return pat.matcher(emailAddress).matches();
  }

  public static boolean isValidNameLength(String firstName) {
    if(firstName.length() < 50){
      return true;
    }
    return false;
  }


  public static boolean isValidPhoneNoLength(String contactNo) {
    if(contactNo.length() == 12 || contactNo.length() == 10) {
      return true;
    }

    return false;
  }

  public static boolean isValidFullNameLength(String fullName) {
    if(fullName.length() < 50) {
      return true;
    }
    return false;
  }

  public static boolean isValidBloodGroup(String bloodGroup) {

    List<String> bloodGroups = new ArrayList<String>();
    bloodGroups.add("APOSITIVE");
    bloodGroups.add("BPOSITIVE");
    bloodGroups.add("OPOSITIVE");
    bloodGroups.add("ABPOSITIVE");
    bloodGroups.add("ANEGATIVE");
    bloodGroups.add("BNEGATIVE");
    bloodGroups.add("ONEGATIVE");
    bloodGroups.add("ABNEGATIVE");

    if( bloodGroups.contains(bloodGroup.trim().toUpperCase())) {
      return true;
    }
    return false;
  }


  public static boolean arePasswordsMatching(String password, String confirmedPassword) {
    return password.equals(confirmedPassword);
  }

  public static boolean isValidVehicleNo(String vehicleNo) {
    if (vehicleNo == null) {
      return false;
    }

    String vehicleNoRegex = "^[A-Za-z]{2}-{1}[0-9]{2}[A-Za-z]{1}-{1}[0-9]{4}$";

    Pattern pat = Pattern.compile(vehicleNoRegex);

    return pat.matcher(vehicleNo).matches();
  }

  public static boolean isValidBusType(int busType) {
    return busType <= 50;
  }

  public static boolean isValidStopCount(int stopCount) {
    return stopCount < 10 && stopCount > 1;
  }

  public static boolean isValidStopNameLength(String stopName) {
    return stopName.length() < 100;
  }

  public static boolean isValidTimeString(String timeString) {
    if (timeString == null) {
      return false;
    }

    String timeStringRegex = "([01]?[0-9]|2[0-3])[/:-][0-5][0-9]$";

    Pattern pat = Pattern.compile(timeStringRegex);

    return pat.matcher(timeString).matches();
  }

  public static boolean isValidUserIdLength(int userId) {
    return userId <= 1000000000 && userId >= 99999999;
  }

  public static boolean isPositive(int number) {
    return number > 0;
  }

  public static boolean isPositive(Long  longNumber) {
    return longNumber > 0;
  }

  public static boolean isAlphabeticWithSpaceAndDots(String stringValue) {

    int alphabetCount = 0, spaceCount = 0, dotCount = 0, totalCount = 0;

    for(int i = 0; i < stringValue.length(); i++) {
      if(stringValue.charAt(i) >= '0' && stringValue.charAt(i) <= '9') {
        return false;
      }

      if(isAlphabetic(stringValue.charAt(i))) {
        ++alphabetCount;
      } else if(stringValue.charAt(i) == '.') {
        ++dotCount;
      } else if(stringValue.charAt(i) == ' ') {
        ++spaceCount;
      }
    }

    totalCount = alphabetCount + dotCount + spaceCount;

    if(totalCount == dotCount || totalCount == spaceCount || totalCount == (spaceCount+dotCount) ||
      spaceCount > alphabetCount || dotCount > alphabetCount) {
      return false;
    }
    return true;
  }
}
