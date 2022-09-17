class AirforceOne {
  private static AirforceOne singleObject;
  int altitude = 1000;

  private AirforceOne() {
  }
  public void fly() {
    System.out.println("Airforce is airborne at " + altitude + " feet ");
  }
  public int getAltitude() {
    return altitude;
  }
  public void setAltitude(int val) {
    this.altitude = val;
  }
  public static AirforceOne getInstance() {
    if (singleObject == null) {
      singleObject = new AirforceOne();
    }
    return singleObject;
  }
}

public class SingletonThree { // client
  public static void main(String[] args) {
    AirforceOne obja = AirforceOne.getInstance();
    // AirforceOne objb = new AirforceOne();
    obja.fly();
    System.out.println("obja altitude = " + obja.getAltitude());
    AirforceOne objb = AirforceOne.getInstance();
    objb.setAltitude(500);
    System.out.println("obja altitude = " + obja.getAltitude());
    System.out.println("objb altitude = " + objb.getAltitude());
  }
}