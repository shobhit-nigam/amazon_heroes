// handled exception 

class Three {
  public static void main(String[] args) {
    try {
      String varx = null; 
      System.out.println("length is " + varx.length());
      System.out.println("another line of code");
    }
    catch (RuntimeException obje ){
      // do something about the exception
      System.out.println("run time exception raised, which is -->");
      System.out.println(obje);
    }

    System.out.println("\nthe code continues");
    
  }
}