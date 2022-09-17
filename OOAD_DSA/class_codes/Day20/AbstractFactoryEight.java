class AbstractFactory {
  public SpeciesFactory getSpeciesFactory(String type) {
    if ("mammal".equals(type)) {
      return new MammalFactory();
    } else if ("bird".equals(type)) {
      return new BirdFactory();
    } else {
      return new MammalFactory();
    }
  }
}

abstract class SpeciesFactory {
  public abstract Animal getAnimal(String type);
}

abstract class Animal {
  public abstract String speak();
}

class MammalFactory extends SpeciesFactory {
  public Animal getAnimal(String type) {
    if ("dog".equals(type)) {
      return new Dog();
    } else if ("cat".equals(type)) {
      return new Cat();
    } else {
      return new Dog();
    }
  }
}

class BirdFactory extends SpeciesFactory {
  public Animal getAnimal(String type) {
    if ("duck".equals(type)) {
      return new Duck();
    } else if ("larry".equals(type)) {
      return new Larry();
    } else {
      return new Duck();
    }
  }
}

class Dog extends Animal {
  @Override
  public String speak() {
    return "bark woof woof";
  }
}

class Cat extends Animal {
  @Override
  public String speak() {
    return "meow meow";
  }
}

class Duck extends Animal {
  @Override
  public String speak() {
    return "quack quack";
  }
}

class Larry extends Animal {
  @Override
  public String speak() {
    return "tweet tweet";
  }
}

public class AbstractFactoryEight {
  public static void main(String[] args) {
    AbstractFactory abs = new AbstractFactory();

    SpeciesFactory spf1 = abs.getSpeciesFactory("mammal");
    Animal tommy = spf1.getAnimal("dog");
    Animal candy = spf1.getAnimal("cat");

    SpeciesFactory spf2 = abs.getSpeciesFactory("bird");
    Animal b1 = spf2.getAnimal("duck");
    Animal b2 = spf2.getAnimal("larry");

    System.out.println(tommy.speak());
    System.out.println(candy.speak());
    System.out.println(b1.speak());
    System.out.println(b2.speak());
  }
}
