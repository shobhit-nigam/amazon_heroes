// multiple inherictance 
class Four {
  public static void main(String[] args) {

    Android obja = new Android();
  }
}

class Unix{
  int varx = 10;
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

class Android extends Linux{
  void ui(){
    System.out.println("great GUI");
  }
}