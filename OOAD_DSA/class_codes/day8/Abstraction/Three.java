// Interfaces

class Three {
  public static void main(String[] args) {
    BatMan objb = new BatMan();
    Tom objt = new Tom();
    objb.darkSide("before", "after");
    objt.darkSide("after");
  }
}

interface SpiderMan {
  abstract void loveLife();

  abstract void antagonist();
}

interface avengers {
  abstract void fightAliens();
}

abstract class superHero {
  abstract void savePlanet();

  final void wearMask() {
    System.out.println("wear masks while fighting");
  }

  void darkSide(String stra) {
    System.out.println("dark side " + stra + " becoming superhero ");
  }

  void darkSide(String stra, String strb) {
    System.out.println("dark side " + stra + " and " + strb + " becoming superhero ");
  }

  void dualIdentity() {
    System.out.println("need to have dual identities");
  }
}

class BatMan extends superHero {
  void savePlanet() {
    System.out.println("save Gotham first");
  }
}

// extend superHero,
// implement avengers, SpiderMan
class Tom extends superHero implements SpiderMan, avengers {
  public void savePlanet() {
    System.out.println("save the fabric of reality");
  }

  public void loveLife() {
    System.out.println("cool MJ");
  }

  public void antagonist() {
    System.out.println("mysterio");
  }

  public void fightAliens() {
    System.out.println("thanos & friends");
  }

}