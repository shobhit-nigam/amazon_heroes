// handled exception 

class NameLengthException extends Exception {
  NameLengthException(String message){
    super(message);
  } 
}

class Fifteen {
  public static void main(String[] args) {
    String name = "jon snow";
    try {
      if (name.length() > 6){
        throw new NameLengthException("name is too long");
      }
      else{
        System.out.println("good name");
      }
    }
    catch (NameLengthException obje){
      System.out.println(obje);
    }
    System.out.println("\nthe code continues");
  }
}