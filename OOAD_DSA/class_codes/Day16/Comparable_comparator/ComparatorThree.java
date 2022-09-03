import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Learner {
  String name;
  Integer marks;

  public Learner(String name, Integer marks) {
    this.name = name;
    this.marks = marks;
  }

  Integer getMarks() {
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

class SortbyMarksAndName implements Comparator<Learner> {
  public int compare(Learner a, Learner b) {
    int MarksCompare = a.getMarks().compareTo(b.getMarks());
    int NameCompare = a.getName().compareTo(b.getName());
    if (MarksCompare == 0) {
      return ((NameCompare == 0) ? MarksCompare : NameCompare);
    } else {
      return MarksCompare;
    }
  }
}

class ComparatorThree {

  public static void main(String[] args) {
    ArrayList<Learner> atlas = new ArrayList<>();

    atlas.add(new Learner("john doe", 59));
    atlas.add(new Learner("jane doe", 64));
    atlas.add(new Learner("rakesh sharma", 33));
    atlas.add(new Learner("rohit sharma", 33));
    atlas.add(new Learner("virat kohli", 64));
    atlas.add(new Learner("virat kohly", 64));

    System.out.println("\nbefore sort\n***********");
    for (int i = 0; i < atlas.size(); i++) {
      System.out.println(atlas.get(i).getName());
    }

    Collections.sort(atlas, new SortbyMarksAndName());

    System.out.println("\nafter sorting by name\n***********");
    for (int i = 0; i < atlas.size(); i++) {
      System.out.println(atlas.get(i).getName());
    }

  }
}
