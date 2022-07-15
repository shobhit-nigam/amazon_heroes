class Two {
 public static void main(String[] args) {
   Bank obja = new Bank();
   obja.display();
   //System.out.println("obja.accType = " + obja.accType);
   //System.out.println("obja.id = " + obja.id);
  }
}

class Bank{
  private int id;
  private int bal;
  public int accType;

  /*public Bank(){
    
  }*/

  public void setValues(int i, int b){
    id = i;
    bal = b;
    return;
  }

  public void display(){
    System.out.println("id is " + id);
    System.out.println("bal is " + bal);
  }
  
}