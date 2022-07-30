//Static

class Two {
  public static void main(String[] args) {
    NolansBatMan Bale = new NolansBatMan();
    BatMan Adam = new BatMan();
//    BatMan Robert = new BatMan();
    Bale.savePlanet();
    Adam.savePlanet();
  }
}

class BatMan {
  int numOfVillians = 0;
  static int numOfEarthSaved = 0;

  static void savePlanet() {
    System.out.println("save Gotham first");
    numOfEarthSaved++;
  }

  void BatMobile() {
  }
}

class NolansBatMan extends BatMan {
  void BatMobile() {
  }

  static void savePlanet() {
    System.out.println("save Planet first");
  }
}
