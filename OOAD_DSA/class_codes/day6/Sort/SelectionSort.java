class SelectionSort {
  public static void main(String[] args) {
    int arr[] = { 88, 14, 32, 25, 79 };
    display(arr);
    sort(arr);
    System.out.println("------");
    display(arr);
  }

  static void sort(int[] la) {
    for (int i = 0; i < la.length; i++) {
      int min = la[i];
      int minIndex = i;
      for (int j = i + 1; j < la.length; j++) {
        if (la[j] < min) {
          min = la[j];
          minIndex = j;
        }
      }
      int temp = la[i];
      la[i] = min;
      la[minIndex] = temp;
    }
    // display(la);
  }

  static void display(int brr[]) {
    for (int i = 0; i < brr.length; ++i) {
      System.out.print(brr[i] + " ");
    }
    System.out.println();
  }
}