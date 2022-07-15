class Four {
  public static void main(String[] args) {
    Bank obja = new Bank("john Doe", 40);
    Bank objb = new Bank("jane Doe", 41);
    Bank objc = new Bank("james doe", 42);
  }
}

class Employee {
  private String name;
  private int age;

  Employee(String name, int age){
    this.name = name;
    this.age = age;
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
  Employee[] arr = new Employee[10];
  private static int countEmployees = 0;
  // countEmployees = 0
  

  Bank(){
  }
  
  Bank(String employeeName, int employeeAge){
    if (countEmployees < 2){
      arr[countEmployees] = new Employee(employeeName, employeeAge);
      System.out.println(employeeName + " at the age of " + employeeAge + " joined the " + bankName + " successfully ");
    }
    else{
      System.out.println("can not create more employees");
    }
    countEmployees++;
  }
 
}

