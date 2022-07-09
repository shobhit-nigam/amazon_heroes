
class ArrayOne {
  public static void main(String[] args) {
    int [] varx = {10, 20, 30};
    int [] arr;
    arr = new int[5];
    for (int i=0; i<varx.length; i++){
      System.out.println("i=" + i + " and varx[i] = " + varx[i]);
    }
    varx[2] = 100;
    varx[3] = 200;
  }
}