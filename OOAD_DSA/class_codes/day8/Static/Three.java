//Static

class Three {
  static int [] arr = new int[10];

  static {
    System.out.println("hello from static block");
    int x = 30;
    System.out.println("x = " + x);
    for (int i=0; i < arr.length; i++){
      arr[i] = i+10;
    }
  }

  public static void main(String[] args) {
    System.out.println("hello from main");
//    System.out.println("x = " + x);
  }

}
