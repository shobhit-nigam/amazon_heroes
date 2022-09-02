import java.util.ArrayList;
import java.util.Collections;

class ArrayListSeven {
  public static void main(String[] args) {
    ArrayList<String> avengers = new ArrayList<>();
    avengers.add("captain");
    avengers.add("ironman");
    avengers.add("thor");
    avengers.add("captain");
    avengers.add("hulk");
    avengers.add("black widow");
    ArrayList<String> new_avengers = new ArrayList<>(avengers);
    new_avengers.add("spiderman");
   // System.out.println(new_avengers);
    for (String ave:avengers){
      System.out.println(ave);
    }
  }
}