class FactoryFive { // client code
  public static void main(String[] args) {
    F16 objf = new F16();
    objf.fly();
  }

}

class F16Engine {

}

class F16Cockpit {

}

class F16 {
  F16Engine engine;
  F16Cockpit cockpit;

  void makeF16() {
    engine = new F16Engine();
    cockpit = new F16Cockpit();
  }

  public void fly() {
    makeF16();
    System.out.println("F16 is airborne");
  }
}
