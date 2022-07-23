class BubbleSortRecursion {
  public static void main(String[] args) {
    int arr[] = { 88, 14, 32, 25, 79 };
    display(arr);
    sort(arr, arr.length);
    System.out.println("------");
    display(arr);
  }

  static void sort(int[] la, int n) {
    if (n == 1) {
      return;
    }

    for (int i = 0; i < n - 1; i++) {
      if (la[i] > la[i + 1]) {
        int temp = la[i];
        la[i] = la[i + 1];
        la[i + 1] = temp;
      }
      display(la);
    }
    sort(la, n - 1);
  }

  static void display(int brr[]) {
    for (int i = 0; i < brr.length; ++i) {
      System.out.print(brr[i] + " ");
    }
    System.out.println();
  }
}