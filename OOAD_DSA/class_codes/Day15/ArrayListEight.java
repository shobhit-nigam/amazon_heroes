import java.util.ArrayList;
import java.util.Collections;

class ArrayListEight {
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> data = new ArrayList<>(3);
    for (int i=0; i<3; i++){
      data.add(new ArrayList());
    }
    data.get(0).add(100);
    data.get(1).add(88);
    data.get(2).add(66);
  for (int i =0; i<3; i++){
    int internal_size = data.get(i).size();
    for(int j=0; j< internal_size; j++){
      System.out.println(data.get(i).get(j));
    }
  }
  }
  
}
data
  arraylist
    int  int
  arraylist
    int  int
  arraylist
    int  int