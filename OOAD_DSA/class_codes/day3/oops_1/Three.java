class Three {
 public static void main(String[] args) {
   Bank obja = new Bank();
   obja.display();
   obja.setValues(234680, 2000);
   System.out.println("--------");
   obja.display();
   obja.setValues(234680, 3000, "savings");
   System.out.println("--------");
   obja.display();   
  }
}
class Bank{
  private int id;
  private int bal;
  public String accType;

  public Bank(){
    
  }

  public void setValues(int i, int b){
    id = i;
    bal = b;
    return;
  }

  public void setValues(int i, int b, String a){
    id = i;
    bal = b;
    accType = a;
    return;
  }

  public void display(){
    System.out.println("id is " + id);
    System.out.println("bal is " + bal);
    System.out.println("account type is " + accType);
  }
  
}