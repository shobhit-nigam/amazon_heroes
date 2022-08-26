// handled exception 

class Eleven {
  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40 };
    int index = 13;
    if (index > arr.length){
      throw new ArithmeticException("index given is out of bounds");
    }
    System.out.println("\nthe code continues");
  }
}