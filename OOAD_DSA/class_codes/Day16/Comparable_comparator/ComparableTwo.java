import java.util.ArrayList;
import java.util.Collections;

class Learner implements Comparable<Learner> {
  String name;
  int marks;

  public Learner(String name, int marks) {
    this.name = name;
    this.marks = marks;
  }

  int getMarks() {
    return marks;
  }

  String getName() {
    return name;
  }

  public int compareTo(Learner obja) {
    if (this.marks == obja.marks) {
      return 0;
    } else {
      return this.marks > obja.marks ? 1 : -1;
    }
  }
}

class ComparableTwo {

  public static void main(String[] args) {
    ArrayList<Learner> atlas = new ArrayList<>();

    atlas.add(new Learner("john doe", 59));
    atlas.add(new Learner("jane doe", 64));
    atlas.add(new Learner("rakesh sharma", 33));

    for (int i =0; i<atlas.size(); i++){
      System.out.println(atlas.get(i).getName());
    }

    Collections.sort(atlas, Collections.reverseOrder());
  System.out.println("after sorting\n***********");
    for (int i =0; i<atlas.size(); i++){
      System.out.println(atlas.get(i).getName());
    }

  }
}