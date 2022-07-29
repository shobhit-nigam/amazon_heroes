class Three {
  public static void main(String[] args) {
    Unix obju = new Unix();
    Linux objl = new Linux();
    objl.cmd();
    System.out.println("varx of obju =" + obju.varx);
    System.out.println("varx of objl =" + objl.varx);
    obju.varx = 20;
    System.out.println("after changing");
    System.out.println("varx of obju =" + obju.varx);
    System.out.println("varx of objl =" + objl.varx);
  }
}

class Unix{
  int varx = 10;
  void cmd(){
    System.out.println("great command line");
    support();
  }
  void secure(){
    System.out.println("rwx makes it secure");
  }
  private void support(){
    System.out.println("good support & service");
  }
}

class Linux extends Unix{
  void free(){
    System.out.println("opensource makes it free");
  }
  // cmd()
  // secure()
}