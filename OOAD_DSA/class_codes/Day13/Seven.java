// handled exception 

class Seven {
  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40 };
    String varx = "hello world"; 
    try {
      // outer try
      try{
        // nested try
        // if  divide by zero 
      System.out.println(arr[6]);
      System.out.println(20/0);
      System.out.println("length is " + varx.length()/varx.indexOf('h'));
      } 
      catch (NullPointerException obje) {
      // do something about the exception
      System.out.println("run time exception raised, which is -->");
      System.out.println(obje);
      } 

      // one more exception 
    }

    catch (ArithmeticException obje) {
      System.out.println("caught the zero issue");
    } 
    catch (ArrayIndexOutOfBoundsException obje) {
      System.out.println("trying to access invalid index, will default it to zero");
      System.out.println("value is --> " + arr[0]);
    }
    catch(Exception obje){
      System.out.println("something went wrong");
    }
    System.out.println("\nthe code continues");

  }
}