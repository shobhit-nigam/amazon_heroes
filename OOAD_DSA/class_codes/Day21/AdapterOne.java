class AdapterOne {
  public static void main(String[] args) {
    HotAirBalloon objh = new HotAirBalloon();
    Adapter obja = new Adapter (objh);
    obja.fly();
  }}


interface IAircraft {
  void fly();
}

class HotAirBalloon {
  String fuel = "helium";

  void fly(String fuelUsed) {
    // take off depends on the kind of fuel
    // some code
  }

  String fillFuel() {
    return fuel;
  }
}

class Adapter implements IAircraft {
  HotAirBalloon objh;

  public Adapter(HotAirBalloon objh) {
    this.objh = objh;
  }

  public void fly() {
    String fuelUsed = objh.fillFuel();
    objh.fly(fuelUsed);
  }
}