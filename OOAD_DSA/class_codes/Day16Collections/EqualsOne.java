class Data {
  int val;
  String code;

  Data(int val, String code) {
    this.val = val;
    this.code = code;
  }
  boolean equals(Data objx){
    boolean temp = (this.val == objx.val) || (this.code == objx.code);
    return temp;
  }
  
}

class EqualsOne {
  public static void main(String[] args) {
    Data obja = new Data(10, "aa");
    Data objb = new Data(10, "aa");
    if (obja == objb) {
      System.out.println("equal");
    } else {
      System.out.println("not equal");
    }

    if (obja.equals(objb)){
      System.out.println("equal");
    } else {
      System.out.println("not equal");
    }
  }
}