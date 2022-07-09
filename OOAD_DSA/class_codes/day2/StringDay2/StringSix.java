class StringSix{
  public static void main(String[] args) {

// String literals pool 
    
    String stra = "atlas aws amazon";
    String [] arr = stra.split("a", 3);
    System.out.println("number of strings = " + arr.length);
    System.out.println("--------");
  
    System.out.println("--------");
  for (String word: arr){
    System.out.println("word = " +word);
    System.out.println("length of word = " + word.length());
  }
  }
}