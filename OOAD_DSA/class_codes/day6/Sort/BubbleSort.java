class BubbleSort {
  public static void main(String[] args) {
    int arr[] = { 88, 14, 32, 25, 79 };
    display(arr);
    sort(arr);
    System.out.println("------");
    display(arr);
  }

  static void sort(int[] la) {
    boolean flag = false;
    int temp;
    while (!flag) {
      flag = true;
      for (int i = 0; i < la.length - 1; i++) {
        if (la[i] > la[i + 1]) {
          temp = la[i];
          la[i] = la[i + 1];
          la[i + 1] = temp;
          flag = false;
        }
      }
      display(la);
    }
  }

  static void display(int brr[]) {
    for (int i = 0; i < brr.length; ++i) {
      System.out.print(brr[i] + " ");
    }
    System.out.println();
  }
}