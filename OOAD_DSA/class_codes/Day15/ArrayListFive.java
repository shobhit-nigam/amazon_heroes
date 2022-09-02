import java.util.ArrayList;
import java.util.ListIterator;

class ArrayListFive {
  public static void main(String[] args) {
    ArrayList<String> avengers = new ArrayList<>();
    avengers.add("captain");
    avengers.add("ironman");
    avengers.add("thor");
    avengers.add("captain");
    avengers.add("hulk");
    avengers.add("black widow");
    System.out.println(avengers.contains(("ironman")));
    System.out.println(avengers.indexOf("captain"));
    System.out.println(avengers.lastIndexOf("captain"));
  }
}