import java.util.ArrayList;
import java.util.Collections;

class Avenger {
  String name;
  String weapon;

  Avenger(String name, String weapon) {
    this.name = name;
    this.weapon = weapon;
  }
}

class ArrayListSix {
  public static void main(String[] args) {
    ArrayList<Avenger> avengers = new ArrayList<>();
    avengers.add(new Avenger("captain", "shield"));
    avengers.add(new Avenger("thor", "hammer"));
    avengers.add(new Avenger("ironman", "suit"));
    avengers.add(new Avenger("hulk", "smash"));
    for (int i=0; i< avengers.size(); i++){
      Avenger temp = avengers.get(i);
      System.out.println(temp.name + " " + temp.weapon);
    }
  }
}