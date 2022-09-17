interface Vehicle {
  public void move();
}

class Traveler {
  Vehicle v;

  public void start() {
    v.move();
  }

  public Vehicle getV() {
    return v;
  }

  public void setV(Vehicle v) {
    this.v = v;
  }
}

class Car implements Vehicle {
  @Override
  public void move() {
    System.out.println("car is moving");
  }
}

class Bike implements Vehicle {
  @Override
  public void move() {
    System.out.println("bike is moving");
  }
}

public class VehicleLooseCoupling {
  public static void main(String[] args) {
    Traveler t = new Traveler();
    // vehicle v = new Bike();
    // Traveler t = new Traveler(v);
    t.setV(new Bike()); // injected bike dependency
    t.start();
    t.setV(new Car()); // injected bike dependency
    t.start();
  }
}
