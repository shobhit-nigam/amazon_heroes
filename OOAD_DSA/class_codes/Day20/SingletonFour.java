class AirforceOne {
  private volatile static AirforceOne singleObject;
  int altitude = 1000;

  private AirforceOne() {
  }

  public void fly() {
    System.out.println("Airforce is airborne at " + altitude + " feet ");
  }
    if (singleObject == null) {
      synchronized public static AirforceOne getInstance() {
      if (singleObject == null) {
        synchronized (AirforceOne.class){
        singleObject = new AirforceOne();
        }
      }
    }
    return singleObject;
  }
}

public class SingletonTwo { // client
  public void main(String[] args) {
    AirforceOne obja = AirforceOne.getInstance();
    // AirforceOne objb = new AirforceOne();
    obja.fly();

  }
}