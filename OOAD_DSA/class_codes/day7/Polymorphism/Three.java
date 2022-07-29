// constructors overloading
class Three {
  public static void main(String[] args) {
    Unix obju = new Unix();
    Unix objv = new Unix(20);
  }
}

class Unix {

  Unix() {
    System.out.println("constructor with zero parameters");
  }

  Unix(int temp) {
    System.out.println("constructor with one integer");
  }

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

  void cmd() {
    System.out.println("great command line and also decent UI");
  }
}
