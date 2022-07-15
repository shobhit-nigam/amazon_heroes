class Five {
 public static void main(String[] args) {
   Bank objw = new Bank();
   Bank objx = new Bank(234680, 2000);
   Bank objy = new Bank(234682, 3000, "savings");
   objw.display();
   System.out.println("--------");
   objx.display();
   System.out.println("--------");
   objy.display();   
  }
}
class Bank{
  private int id;
  private int bal;
  public String accType;

  Public Bank(){
    System.out.println("from constructor with zero arguments");
  }

  public Bank(int id, int bal){
    this 
    System.out.println("from constructor with two arguments");
    this.id = id;
    this.bal = bal;
  }

  public Bank(int id, int b, String a){
    System.out.println("from constructor with three arguments");
    this.id = id;
    bal = b;
    accType = a;
  }

  public void display(){
    System.out.println("id is " + this.id);
    System.out.println("bal is " + bal);
    System.out.println("account type is " + accType);
  }
  
}