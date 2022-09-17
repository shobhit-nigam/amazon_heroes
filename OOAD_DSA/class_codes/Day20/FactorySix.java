import java.util.ArrayList;

class FactoryFive { // client code
  public static void main(String[] args) {
    ArrayList<F16> listObja = new ArrayList<F16>();
    F16 f16H = new F16HighSpeed();
    F16 f16L = new F16LowSonic();

    listObja.add(f16H);
    listObja.add(f16L);

  }

}

class F16Engine {
}

class F16Cockpit {
}

class F16HighSpeedEngine extends F16Engine {

}

class F16LowSonicEngine extends F16Engine {

}

class F16 {
  F16Engine engine;
  F16Cockpit cockpit;
  String Parachute;

  protected F16 makeF16() {
    // engine = new F16Engine();
    cockpit = new F16Cockpit();
    Parachute = new String();
    return this;

  }

  public void taxi() {
    System.out.println("F16 is taxing on the runway");
  }

  public void fly() {
    F16 objf = makeF16();
    objf.taxi();
    System.out.println("F16 is airborne");
  }
}

class F16HighSpeed extends F16 {
  @Override
  public F16 makeF16() {
    super.makeF16(); // creation of rest of the Fighter jet body parts
    engine = new F16HighSpeedEngine();
    return this;
  }

}

class F16LowSonic extends F16 {
  @Override
  public F16 makeF16() {
    super.makeF16(); // creation of rest of the Fighter jet body parts
    engine = new F16LowSonicEngine();
    return this;
  }
}
