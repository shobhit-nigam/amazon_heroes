import java.util.HashSet;

public class HashSetOne {
  public static void main(String[] args){
    HashSet<String> one = new HashSet<String>();
    one.add("ronaldo");
    one.add("messi");
    one.add("ronaldo");
    one.add("mbappe");
  ///////////////////////
    HashSet<String> two = new HashSet<String>();
    two.add("ronaldo");
    two.add("messi");
    two.add("zlatan");
    two.add("robben");

  // union
    HashSet<String> union = new HashSet<String>(one);
    union.addAll(two);
    System.out.println(union);
    
  }
}