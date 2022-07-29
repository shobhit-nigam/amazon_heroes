class One {
  public static void main(String[] args) {
    Unix obju = new Unix();
    Linux objl = new Linux();
    objl.cmd();
    objl.free();
  }
}

class Unix{
  void cmd(){
    System.out.println("great command line");
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