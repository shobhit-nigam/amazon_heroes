
class StringNine {
  public static void main(String[] args) {

// String literals pool 
    StringBuffer strb = new StringBuffer("atlas");
    // 21 ( 5 + 16)
    System.out.println("strb = " + strb);
    strb.insert(2, " ");
    strb.append("t");
    System.out.println("----------");
    System.out.println("strb = " + strb);
    
  }
}