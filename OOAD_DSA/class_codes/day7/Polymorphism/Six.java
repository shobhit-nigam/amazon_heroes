
// method overloading & overriding
class Six {
  public static void main(String[] args) {
    Unix obju = new Unix();
    Linux objl = new Linux();
    objl.secure("rwx");
    objl.secure("rwx", "firewall");
  }
}

class Unix {
  void cmd() {
    System.out.println("great command line");
  }

  void secure(String x) {
    System.out.println(x + " makes it secure");
  }

  void secure(String x, String y) {
    System.out.println("secure thorugh " + x + " and " + y);
  }
}

class Linux extends Unix {
  void free() {
    System.out.println("opensource makes it free");
  }

  void secure(String x) {
    System.out.println("Linux gives more security");
  }
}
