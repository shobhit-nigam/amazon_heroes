package tools;

import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class Validator {
	private static int MIN_PASSWORD_LENGTH = 8;
	
	/* 
	 * 8 chars, letters & digits only, atleast 1 digit
	 */
	
	public static boolean isValidPassword(String password) {
		if (password.length() < MIN_PASSWORD_LENGTH) {
			return false;
		}
		int charCount = 0;
		int numCount = 0;
		
		for (int i=0; i<password.length(); i++) {
			char ch = password.charAt(i);
			
			if (isNumeric(ch)) {
				numCount++;
			}else if(isAlphabetic(ch)) {
				charCount++;
			}else {
				return false;
			}
		}
		return (charCount >=1 && numCount >=1);
	}
	public static boolean isAlphabetic(char ch) {
		ch = Character.toLowerCase(ch);
		return (ch >= 'a' && ch <= 'z');
	}
	public static boolean isNumeric(char ch) {
		return (ch >= '0' && ch <= '9');
	}
	public static boolean isNumeric(String stringVal) {
		try {
			Double.parseDouble(stringVal);
		} catch(NumberFormatException obje) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidEmail(String emailAddress) {
		if (emailAddress == null ) {
			return false;
		}
		String firstPart = emailAddress.substring(0, emailAddress.indexOf("@"));
		
		if (!emailAddress.endsWith("@amazon.com")) {
			return false;
		}
		
		String emailPat = "[a-zA-Z.0-9_]+";
		
		Pattern pat = Pattern.compile(emailPat);
		return pat.matcher(firstPart).matches();

		}
	
	public static boolean isvalidPhoneNum(String contactNo) {
		if(contactNo.length() != 10) {
			return false;
		}
		try {
			Double.parseDouble(contactNo);
		} catch(NumberFormatException obje) {
			return false;
		}
		return true;	
	}
	
	public static boolean isValidFullNameLenght(String fullName) {
		return fullName.length() < 60;
	}
	
	public static boolean isValidNameLenght(String firstName) {
		return firstName.length() < 60;
	}
	
	public static boolean arePasswordsMatching(String password, String confirmedPassword) {
		return password.equals(confirmedPassword);
	}
	
	public static boolean isValidBusType(int busType) {
		return busType <= 50;
	}
	
	public static boolean isValidStopNameLenght(String firstName) {
		return firstName.length() < 100;
	}
	public static boolean isValidStopCount (int stopCount) {
		return stopCount < 10 && stopCount > 1;
	}
	public static boolean isValidTimeString (String timeString) {
		if (timeString == null) {
			return false;
		}
		String timeStringRegex = "([01]?[0-9]|2[0-3])[/:-][0-5][0-9]$";
				// 18:34 or 18-34
		Pattern pat = Pattern.compile(timeStringRegex);
		return pat.matcher(timeString).matches();
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
	
	  public static boolean isPositive(int number) {
		    return number > 0;
		  }

	  public static boolean isPositive(Long  longNumber) {
	    return longNumber > 0;
	  }
	public static boolean isValidBloodGroup(String bloodGroup) {
		List <String> bloodGroups = new ArrayList<String>();
		bloodGroups.add("A+");
		bloodGroups.add("B+");
		bloodGroups.add("O+");
		bloodGroups.add("AB+");
		bloodGroups.add("A-");
		bloodGroups.add("B-");
		bloodGroups.add("AB-");
		bloodGroups.add("O-");
		
		if (bloodGroups.contains(bloodGroup.trim().toUpperCase())) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidComment(String comment) {
		if(comment.length() <= 100 && comment.length() > 1) {
			return true;
		}
		return false;
	}
	public static boolean isCommentBlank(String comment) {
		if(comment.trim().contentEquals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidVehicleNo(String vehicleNo) {
	//KA32-e-9382
	String vehicleNoRegex = "^[a-zA-Z]{2}[0-9]{2}-[a-zA-Z]-[0-9] {4}$";
	Pattern pat = Pattern.compile(vehicleNoRegex);
	return pat.matcher(vehicleNo).matches();
	}
	public static boolean isValidUserIdLength(int userId) {
		return userId <=1000000000 && userId >=99999999;
	}
	public static boolean isValidStopNameLength(String stopName) {
		return stopName.length() <100;
	}

}
