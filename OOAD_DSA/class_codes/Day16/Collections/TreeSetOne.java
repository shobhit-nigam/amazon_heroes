import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetOne {
  public static void main(String[] args) {
    TreeSet<Integer> one = new TreeSet<Integer>();
    one.add(100);
    one.add(63);
    one.add(123);
    one.add(75);
    one.add(45);
    one.add(100);
    ///////////////////////
    Iterator<Integer> it = one.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    System.out.println("*************");
    System.out.println(one.pollFirst());
    System.out.println("*************");
    Iterator<Integer> is = one.iterator();
    while (is.hasNext()) {
      System.out.println(is.next());
    }

  }
}