class AdapterTwo {
  public static void main(String[] args) {
    // driver = new Tesla(new CarAdapter());
    // driver.accelerate();
  }
}

interface IAutomatic {
  void accelerate();
}

class GearedCar {
  public void changeGear() {
    // code for changing gear & then acelerating
  }
}

class Tesla {
  IAutomatic obja;

  public Tesla(IAutomatic obja) {
    this.obja = obja;
  }

  public void accelerate() {
    obja.accelerate();
  }
}

class CarAdapter implements IAutomatic {
  GearedCar objg;

  public CarAdapter() {
    objg = new GearedCar();
  }

  @Override
  public void accelerate() {
    objg.changeGear();
  }
}