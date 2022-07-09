class StringTwo {
  public static void main(String[] args) {

// String literals pool 
    
    String stra = "atlas";
    System.out.println("stra = " + stra.length());
    System.out.println("stra = " + stra.toUpperCase());
//  dynamic allocation (heap)
    String strb = new String("prime");
  }
}