// handled exception 

class Ten {
  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40 };
    String varx = "hello world"; 
    try{
//      System.out.println(20/0);
      System.out.println(arr[7]);
    } 
    catch(ArithmeticException obje){
      System.out.println("catch block");
    }
    finally {
      System.out.println("finally block");
    }
    System.out.println("\nthe code continues");
  }
}