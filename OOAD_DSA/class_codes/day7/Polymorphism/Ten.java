// parent constructor being called implicitly  
class Ten {
  public static void main(String[] args) {
    Linux objl = new Linux();
    objl.free();
  }
}

class Unix {
  Unix() {
    System.out.println("constructor for Unix");
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
    System.out.println("constructor for Linux");
  }

  void cmd() {
    System.out.println("great command line with good UI");
  }

  void free() {
    System.out.println("opensource makes it free\n calling cmd");
    super.cmd();
  }
}
