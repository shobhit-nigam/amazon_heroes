// handled exception 

class Five {
  public static void main(String[] args) {
    try {
      String varx = "hello world"; 
      System.out.println("length is " + varx.length()/varx.indexOf('h'));
      System.out.println("another line of code");
    }
    catch (NullPointerException obje ){
      // do something about the exception
      System.out.println("run time exception raised, which is -->");
      System.out.println(obje);
    }
    catch (ArithmeticException obje){
      System.out.println("caught the zero issue");
    }

    System.out.println("\nthe code continues");
    
  }
}