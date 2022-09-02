import java.util.ArrayList;
import java.util.List;

class ArrayListOne {
  public static void main(String[] args) {
    ArrayList<String> avengers = new ArrayList<>();
    // List<String> avengers = new ArrayList<>();
    // size 10
    avengers.add("captain");
    avengers.add("ironman");
    avengers.add("thor");
    avengers.add("captain");
    avengers.add("hulk");
    System.out.println(avengers);
    avengers.add(3, "black widow");
    System.out.println(avengers);
    avengers.set(2, "loki");

    System.out.println(avengers);

  }
}