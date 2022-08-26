// handled exception 

class Two {
  public static void main(String[] args) {
    try {
      String varx = null; 
      System.out.println("length is " + varx.length());
      System.out.println("another line of code");
    }
    catch (NullPointerException obje ){
      // do something about the exception
      System.out.println("exception raised, which is -->");
      System.out.println(obje);
    }

    System.out.println("\nthe code continues");
    
  }
}