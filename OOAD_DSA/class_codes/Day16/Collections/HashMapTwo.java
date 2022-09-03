import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class HashMapTwo {
  public static void main(String[] args) {
    Map<String, Integer> one = new HashMap<String, Integer>();
    one.put("aa", 100);
    one.put("dd", 63);
    one.put("ww", 123);
    one.put("gg", 75);
    one.put(null, 90);
    ///////////////////////
    System.out.println(one);
    System.out.println("******");
    one.put("ww", 56);
    System.out.println(one);
    System.out.println("******");
    one.put("kk", 20);
    System.out.println(one);
    System.out.println("******");
    one.putIfAbsent("ww", 200);
    System.out.println(one);
  }
}