public class DecoratorFive {
  public static void main(String[] args) {
    Aircraft normalAirbus = new AirBus();
    Aircraft luxuryAirbus = new LuxuryChairs(normalAirbus);
    System.out.println("weight with luxury chairs = " + luxuryAirbus.getWeight());
    Aircraft extraAirbus = new ExtraBaggage(luxuryAirbus);
    System.out.println("final weight with extra baggage = " + extraAirbus.getWeight());

    // ArrayList<int> obji = new ArrayList<int>();
    // ArrayList<Integer> obji = new ArrayList<Integer>();
  }
}

interface Aircraft {
  int baseWeight = 100;

  void fly();

  void land();

  int getWeight();
}

class AirBus implements Aircraft {
  public void fly() {
    System.out.println("AirBus flies");
  }

  public void land() {
    System.out.println("AirBus lands");
  }

  public int getWeight() {
    return baseWeight;
  }
}

abstract class AirBusDecorator implements Aircraft {

}

class LuxuryChairs extends AirBusDecorator {
  int chairWeight = 33;
  Aircraft obja;

  public LuxuryChairs(Aircraft obja) {
    this.obja = obja;
  }

  public void fly() {
    obja.fly();
  }

  public void land() {
    obja.land();
  }

  public int getWeight() {
    return (chairWeight + obja.getWeight());
  }

}

class ExtraBaggage extends AirBusDecorator {
  int extraBags = 20;
  Aircraft obja;

  public ExtraBaggage(Aircraft obja) {
    this.obja = obja;
  }

  public void fly() {
    obja.fly();
  }

  public void land() {
    obja.land();
  }

  public int getWeight() {
    return (extraBags + obja.getWeight());
  }

}
