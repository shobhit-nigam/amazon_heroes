// handled exception 

class Seventeen {
  static void method_a() throws ArithmeticException, IllegalAccessException{
    System.out.println("inside method_a");
//        throw new ArithmeticException("arth exception");
  }
  
  public static void main(String[] args) {
    try {
      method_a();
    } 
    catch (IllegalAccessException obje){
      System.out.println("catch block");
    }
  }
}  