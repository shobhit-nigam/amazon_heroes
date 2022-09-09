import java.util.Arrays;

class AppointmentThree {
  public static void main(String[] args) {
    int start[] = { 700, 730, 740, 900, 1200, 1400 };
    int end[] = { 715, 950, 910, 930, 1300, 1430 };
    Optimsed obja = new Optimsed();
    int num_of_nurses = obja.numNurses(start, end);
    System.out.println("num of nurses needed = " + num_of_nurses);
  }
}

class Optimsed {
  public int numNurses(int[] start, int[] end) {
    Arrays.sort(start);
    Arrays.sort(end);
    
    int total_num_of_nurses = 1;
    int  num_of_nurses = 1;
    int i=1;  int j=0;

    while((i<start.length) && (j<start.length)){
      if (start[i] < end[j]){
        num_of_nurses ++;
        i++;
        if(num_of_nurses > total_num_of_nurses){
          total_num_of_nurses = num_of_nurses;
        }
        }
      else{
        num_of_nurses --;
        j++;
      }
    }
    return total_num_of_nurses;
  }
}