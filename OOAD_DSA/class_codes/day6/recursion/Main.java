class Main {
  public static int count = 0;
  public static void main(String[] args) {
    int res = add(4);
    //System.out.println(res);
  }

  public static int add(int num){
    count ++;
    System.out.println("called add " + count + " times ");
    System.out.println("and value of num is " + num);
    System.out.println("------");
    if (num > 0){
      return num + add (num -1);
    }
    else {
      return 0;
    }
  }
}