class One {
  public static void main(String[] args) {
    Name objn = new Name();

    System.out.println(objn.getName());
    objn.setAge(24);
    objn.setName("John Doe");

    System.out.println(objn.getName());
  }
}

class Name {
  private String name;
  private int age;

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