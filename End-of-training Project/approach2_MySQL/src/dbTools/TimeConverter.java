package dbTools;

/**
 * The class TimeConverter is a helper class used to convert 24-hour format time strings to minutes
 * on a day and vice-verse.
 * Used by Upper Layers
 **/

public class TimeConverter {

  // Returns time in minutes from a time string with 24-hour format
  public static int getTimeAsMinutes(String timingString) {
    String[] timingArray = timingString.split(("[/:-]"));

    int hourPart = Integer.parseInt(timingArray[0]);
    int minutePart = Integer.parseInt(timingArray[1]);

    int timeInMinutes = (hourPart*60) + minutePart;

    return timeInMinutes;
  }

  // Returns a time string with 24-hour format from time in minutes
  public static String getTimeAsString(int timingInMinutes) {
    int hourPart = timingInMinutes/60;
    int minutePart = timingInMinutes%60;

    String hourString = "";
    String minuteString = "";

    if(hourPart == 24){
      hourPart = 0;
    }

    if(hourPart < 10){
      hourString = "0"+hourPart;
    } else {
      hourString = "" + hourPart;
    }

    if(minutePart < 10) {
      minuteString = "0" + minutePart;
    } else {
      minuteString = "" + minutePart;
    }

    String resultTimeString = hourString + ":" + minuteString;

    return resultTimeString;
  }
}
