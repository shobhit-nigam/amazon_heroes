class Six {
 public static void main(String[] args) {
   Bank objw = new Bank(234678, 1000);
   Bank objx = new Bank(234680, 2000);
   static int z = 45;
   objw.display();
   System.out.println("--------");
   objx.display();
   objw.bal = objw.bal + 500;
   objw.accType = "current";
   System.out.println("having made the chnages\n ++++++++++++");
   objw.display();
   System.out.println("--------");
   objx.display();
   System.out.println("--------");
   Bank objy = new Bank(234682, 1500);
   objy.display();
   
  }
}
class Bank{
  private int id;
  public int bal;
  public static String accType = "savings";
  public Bank(){
  }

  public Bank(int id, int bal){
    this.id = id;
    this.bal = bal;
  }

  public void display(){
    System.out.println("id is " + this.id);
    System.out.println("bal is " + bal);
    System.out.println("account type is " + accType);
  }
  
}