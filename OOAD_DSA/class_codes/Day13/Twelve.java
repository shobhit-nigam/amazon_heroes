// handled exception 

class Twelve {
  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40 };
    int index = 13;
    try {
      if (index > arr.length){
        throw new ArithmeticException("index given is out of bounds");
      }
    }
    catch (ArithmeticException obje){
      System.out.println("handling the arth exception");
    }
    System.out.println("\nthe code continues");
  }
}