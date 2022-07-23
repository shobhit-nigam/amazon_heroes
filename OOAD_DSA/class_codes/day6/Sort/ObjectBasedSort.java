public class ObjectBasedSort {
  public static void main(String[] args){
    Names [] delegates;
    delegates = new Names[5];

    delegates[0] = new Names("fffff", 25);
    delegates[1] = new Names("trgug", 27);
    delegates[2] = new Names("hjuik", 21);
    delegates[3] = new Names("gwdsf", 33);
    delegates[4] = new Names("bqwty", 22);
    
    namesSort(delegates);
  }
  public static void namesSort(Names [] data){
    int n = data.length;
    for (int i=0; i<n; i++){
      int min_age = i;
      for (int j = i+1; j<n; j++){
        if (data[j].getAge() < data[min_age].getAge()){
          min_age = j;
        }
      }
      Names temp = data[min_age];
      data[min_age] = data[i];
      data[i] = temp;
      System.out.println(data[i].toString());
    }
  }
}

class Names {
  String name = "xxxx";
  int age = 0;

  public Names(String name, int age){
    this.name = name;
    this.age = age;
  }

  public String getName(){
    return name;
  }

  public void setName(String newName){
    this.name = newName;
  }

  public int getAge(){
    return age;
  }

  public void setAge(int newAge){
    this.age = newAge;
  }

  public String toString(){
    return this.name + " " + this.age;
  }
}