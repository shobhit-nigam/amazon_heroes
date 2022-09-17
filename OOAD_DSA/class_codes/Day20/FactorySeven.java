
abstract class Animal {
  public abstract String speak();
}

class AnimalFactory {
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

public class FactorySeven {
  public static void main(String[] args) {
    AnimalFactory animalFactory = new AnimalFactory();
    Animal tommy = animalFactory.getAnimal("dog");
    Animal candy = animalFactory.getAnimal("cat");

    System.out.println(tommy.speak());
    System.out.println(candy.speak());
  }
}
