import java.util.ArrayList;
import java.util.ListIterator;

class ArrayListThree {
  public static void main(String[] args) {
    ArrayList<String> avengers = new ArrayList<>();
    avengers.add("captain");
    avengers.add("ironman");
    avengers.add("thor");
    avengers.add("captain");
    avengers.add("hulk");
    avengers.add("black widow");
    ListIterator<String> avengerIterator = avengers.listIterator();
    while (avengerIterator.hasNext()) {
      String objtemp = avengerIterator.next();
      System.out.println(objtemp);
    }
  }
}