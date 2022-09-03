import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Learner {
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
}

class SortbyMarks implements Comparator<Learner> {
  public int compare(Learner a, Learner b) {
    return a.marks - b.marks;
  }
}

class SortbyName implements Comparator<Learner> {
  public int compare(Learner a, Learner b) {
    return a.name.compareTo(b.name);
  }
}

class ComparatorThree {

  public static void main(String[] args) {
    ArrayList<Learner> atlas = new ArrayList<>();

    atlas.add(new Learner("john doe", 59));
    atlas.add(new Learner("jane doe", 64));
    atlas.add(new Learner("rakesh sharma", 33));

    System.out.println("\nbefore sort\n***********");
    for (int i = 0; i < atlas.size(); i++) {
      System.out.println(atlas.get(i).getName());
    }

    Collections.sort(atlas, new SortbyMarks());

    System.out.println("\nafter sorting by marks\n***********");
    for (int i = 0; i < atlas.size(); i++) {
      System.out.println(atlas.get(i).getName());
    }

    Collections.sort(atlas, new SortbyName());

    System.out.println("\nafter sorting by name\n***********");
    for (int i = 0; i < atlas.size(); i++) {
      System.out.println(atlas.get(i).getName());
    }

  }
}