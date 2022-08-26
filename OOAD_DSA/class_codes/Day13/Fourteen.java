// handled exception 

class NameLengthException extends Exception {

}

class Fourteen {
  public static void main(String[] args) {
    String name = "jon snow";
    try {
      if (name.length() > 6){
        throw new NameLengthException();
      }
      else{
        System.out.println("good name");
      }
    }
    catch (NameLengthException obje){
      System.out.println("long name");
    }
    System.out.println("\nthe code continues");
  }
}