public class BridgeThree {
  public static void main() {
    AbstractTesla objt = new Tesla_S(new Tesla_S_Impl_India());
    System.out.println(objt.isRightHanded());
    //false

    objt.setTeslaImpl(new Tesla_S_Impl_Canada());
    System.out.println(objt.isRightHanded());
    //true
  }
}

abstract class AbstractTesla {
  AbstractTeslaImpl objtl;

  public AbstractTesla(AbstractTeslaImpl objtl) {
    this.objtl = objtl;
  }

  abstract void batteryStructure();

  abstract boolean isRightHanded();

}

abstract class AbstractTeslaImpl {

  abstract void batteryStructure();

  abstract boolean isRightHanded();

}

class Tesla_S extends AbstractTesla {
  public Tesla_S(AbstractTeslaImpl objtl) {
    super(objtl);
  }

  void batteryStructure() {
    objtl.batteryStructure();
  }

  boolean isRightHanded() {
    return objtl.isRightHanded();
  }
}

class Tesla_S_Impl_Canada extends AbstractTeslaImpl {
  void batteryStructure() {
    System.out.println("great battery");
  }

  boolean isRightHanded() {
    return true;
  }
}

class Tesla_S_Impl_India extends AbstractTeslaImpl {
  void batteryStructure() {
    System.out.println("battery explodes");
  }

  boolean isRightHanded() {
    return false;
  }

}