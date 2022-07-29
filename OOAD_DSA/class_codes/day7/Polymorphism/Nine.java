// parent constructor being called implicitly  
class Nine {
  public static void main(String[] args) {
    Linux objl = new Linux();
  }
}

class Unix {
  Unix(int x) {
    System.out.println("constructor for Unix with one parameter");
  }

  void cmd() {
    System.out.println("great command line");
  }

  void secure(String x) {
    System.out.println(x + " makes it secure");
  }
}

class Linux extends Unix {
  Linux() {
    super(10);
    System.out.println("constructor for Linux");
  }

  void free() {
    System.out.println("opensource makes it free");
  }
}
