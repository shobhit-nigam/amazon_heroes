class Two {
  public static void main(String[] args) {
    Unix obju = new Unix();
    Linux objl = new Linux();
    obju.cmd();
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
    // error because support() has not been inherited
    // as it is private
    support();
  }
  // cmd()
  // secure()
}