class InsertionSort {
  public static void main(String[] args) {
    int arr[] = { 88, 14, 32, 25, 79 };
    // display(arr);
    sort(arr);
    System.out.println("------");
    // display(arr);
  }

  static void sort(int[] la) {
    for (int i = 1; i < la.length; i++) {
      int cur = la[i];
      int j = i - 1;
      while (j >= 0 && cur < la[j]) { // 14 < 88
        la[j + 1] = la[j]; // 88 , 88, 32, 25, 79
        j--;
      }
      la[j + 1] = cur;
      display(la);
      // 14, 88, 32, 25, 79
      // 14, 32, 88, 25, 79
          // 14, 32, 25, 88, 79
          // 14, 25, 32, 88, 79
      // 14, 25, 32, 88, 79
      // 14, 25, 32, 79, 88
    }
  }

  static void display(int brr[]) {
    for (int i = 0; i < brr.length; ++i) {
      System.out.print(brr[i] + " ");
    }
    System.out.println();
  }
}