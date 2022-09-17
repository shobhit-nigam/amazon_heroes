// construction of aircraft:
// 1. cockpit
// 2. engine
// 3. wings 

abstract class AircraftBuilder {
  public void buildEngine() {

  }

  public void buildWings() {

  }

  public void buildCockpit() {

  }

  public void buildBathrooms() {

  }

  abstract public IAircraft getResult();
}

class Airbus360Builder extends AircraftBuilder {
  Airbus360Builder airbus360;

  @Override
  public void buildEngine() {

  }

  @Override
  public void buildWings() {

  }

  @Override
  public void buildCockpit() {

  }

  @Override
  public void buildBathrooms() {

  }

  abstract public IAircraft getResult(){
    return airbus360;
  }
}

class F16Builder extends AircraftBuilder {
  F16Builder f16;

  @Override
  public void buildEngine() {
    // build F16 engine
  }

  @Override
  public void buildWings() {

  }

  @Override
  public void buildCockpit() {
    f16 = new F16();
    // get F-16 cockpit

  }

  public IAircraft getResult(){
    return f16;
  }
}

class Director {
  AircraftBuilder aircraftBuilder;

  public Director(AircraftBuilder obja) {
    this.aircraftBuilder = obja;
  }

  public void construct(boolean isCommercial) {
    aircraftBuilder.buildCockpit();
    aircraftBuilder.buildEngine();
    aircraftBuilder.buildWings();

    if (isCommercial) {
      aircraftBuilder.buildBathrooms();
    }
  }
}

public class BuilderOne {  // client
  public static void main(String[] args) {
    F16Builder f16Builder = new F16Builder();
    Director director = new Director(f16Builder);
    director.construct(false);

    IAicraft f16 = F16Builder.getResult();

  }
}