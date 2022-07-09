
class StringEight {
  public static void main(String[] args) {

// String literals pool 
    StringBuffer stra = new StringBuffer();
    StringBuffer strb = new StringBuffer("atlas");
    // 21 ( 5 + 16)
    System.out.println("length of stra = " + stra.length());
    System.out.println("capacity of stra = " + stra.capacity());
    System.out.println("----------");
    System.out.println("length of strb = " + strb.length());
    System.out.println("capacity of strb = " + strb.capacity());
    
  }
}