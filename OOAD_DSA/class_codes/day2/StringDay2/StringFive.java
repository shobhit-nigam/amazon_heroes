class StringFive{
  public static void main(String[] args) {

// String literals pool 
    
    String stra = "atlas aws amazon";
    String [] arr = stra.split("s");
    System.out.println("arr length = " + arr.length);
    System.out.println("--------");
  
    for (int i=0; i<arr.length; i++){
      System.out.println("arr[i] = " + arr[i]);
    }
    System.out.println("--------");
  for (String word: arr){
    System.out.println(word);
  }
  }
}