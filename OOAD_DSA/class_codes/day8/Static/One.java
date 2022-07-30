//Static

class One {
  public static void main(String[] args) {
    BatMan Bale = new BatMan();
    BatMan Adam = new BatMan();
    BatMan Robert = new BatMan();
    Bale.savePlanet();
    Adam.savePlanet();
    Robert.savePlanet();
    System.out.println("planet saved " + BatMan.numOfEarthSaved + " times");
  }
}

class BatMan {
  int numOfVillians = 0;
  static int numOfEarthSaved = 0;

    void savePlanet() {
    System.out.println("save Gotham first");
    numOfEarthSaved++;
  }

  void BatMobile() {
  }
}
