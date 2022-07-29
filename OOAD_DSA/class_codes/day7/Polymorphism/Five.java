// method overriding
class Five {
  public static void main(String[] args) {
    Unix obju = new Unix();
    Linux objl = new Linux();
    obju.cmd();
    objl.cmd();
  }
}

class Unix{
  void cmd(){
    System.out.println("great command line");
  }
  void secure(){
    System.out.println("rwx makes it secure");
  }
}

class Linux extends Unix{
  void free(){
    System.out.println("opensource makes it free");
  }
  void cmd(){
    System.out.println("great command line and also decent UI");
  }
}
