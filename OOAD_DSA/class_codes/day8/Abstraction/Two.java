class Two {
  public static void main(String[] args) {
    // SpiderMan obja = new SpiderMan();
    Tobey obja = new Tobey();
    obja.loveLife();
  }
}

abstract class SpiderMan {
  SpiderMan() {
    System.out.println("needs to be from queens");
  }

  final void relations() {
    System.out.println("has to be an orphan");
  }

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