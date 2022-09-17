interface Vehicle {
  public void move();
}

class Traveler {
  Car c = new Car();

  public void start() {
    c.move();
  }
}

class Car {
  public void move() {
    System.out.println("car is moving");
  }
}

class Bike {
  public void move() {
    System.out.println("bike is moving");
  }
}

public class VehicleTightCoupling {
  public static void main(String[] args) {
    Traveler t = new Traveler();
    t.start();
  }
}
