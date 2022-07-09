class StringOne {
  public static void main(String[] args) {

// String literals pool 
    
    String stra = "atlas";
    stra = "amazon";
    System.out.println("stra = " + stra);
//  dynamic allocation (heap)
    String strb = new String("prime");
  }
}