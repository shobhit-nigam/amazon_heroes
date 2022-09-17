class AssociationOne {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}

class Learner{
  String name;
  List<Trainer> trainers;
}

class Trainer {
  String name;
  List <Learner> learners;
}

// one-to-many
// one-to-one
// many-to-one
// many-to-many
