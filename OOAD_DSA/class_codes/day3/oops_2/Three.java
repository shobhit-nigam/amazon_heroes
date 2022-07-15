class Two {
  public static void main(String[] args) {
    Bank objb = new Bank("john Doe", 40);
  }
}

class Employee {
  private String name;
  private int age;

  Employee(String name, int age){
    this.name = name;
    this.age = age;
  }
  
  Employee (){
    
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }

  public int getAge(){
    return age;
  }
  public void setAge(int age){
    this.age = age;
  }
}

class Bank{
  private static String bankName = "ubi";
  

  Bank(){
  }
  
  Bank(String employeeName, int employeeAge){
    Employee obje = new Employee(employeeName, employeeAge);
    System.out.println(obje.getName());
  }
  
  public String getName(){
    return bankName;
  }
  public void setName(String name){
    this.bankName = name;
  } 
}

