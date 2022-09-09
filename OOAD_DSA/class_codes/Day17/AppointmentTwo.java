class AppointmentTwo {
  public static void main(String[] args) {
    int start[] = { 700, 730, 740, 900, 1200, 1400 };
    int end[] = { 715, 950, 910, 930, 1300, 1430 };
    Bruteforce obja = new Bruteforce();
    int num_of_nurses = obja.numNurses(start, end);
    System.out.println("num of nurses needed = " + num_of_nurses);
  }
}

class Bruteforce {
  public int numNurses(int[] start, int[] end) {
    int num_of_nurses = 0;
    int count = 0;
    for (int i = 0; i < start.length; i++) {
      count = 0;
      for (int j = 1; j < start.length; j++) {
        if (start[j] >= start[i] && start[j] <= end[i]) {
          count++;
        }
      }
      if (count > num_of_nurses) {
        num_of_nurses = count;
      }
    }
    return num_of_nurses;
  }
}