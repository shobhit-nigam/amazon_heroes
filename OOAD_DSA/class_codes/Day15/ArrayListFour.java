import java.util.ArrayList;
import java.util.Collections;

class ArrayListFour {
  public static void main(String[] args) {
    ArrayList<String> avengers = new ArrayList<>();
    avengers.add("captain");
    avengers.add("ironman");
    avengers.add("thor");
    avengers.add("captain");
    avengers.add("hulk");
    avengers.add("black widow");
    System.out.println(avengers);
    Collections.sort(avengers);
    System.out.println(avengers);
  }
}