class One {
  public static void main(String[] args) {
    // SpiderMan obja = new SpiderMan();
    Tobey obja = new Tobey();
    obja.loveLife();
  }
}

abstract class SpiderMan {
  abstract void loveLife();

  void createWebs() {
    System.out.println("launch webs\n");
  }

  abstract void antagonist();
}

class Tobey extends SpiderMan {
  void loveLife() {
    System.out.println("Mary Jane");
  }

  void antagonist() {
    System.out.println("electro");
  }
}