// handled exception 

class Nine {
  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40 };
    String varx = "hello world"; 
    try{
    System.out.println(arr[6]);
    System.out.println(20/0);
    System.out.println("length is " + varx.length()/varx.indexOf('h'));
    } 
    catch(Exception obje){
      System.out.println("something went wrong");
      System.out.println(obje.getStackTrace()[0].getLineNumber());
      // string which has description of the exception 
    }
    System.out.println("\nthe code continues");

  }
}