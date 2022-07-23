class MergeSort {
  public static void main(String[] args) {
    int arr[] = { 88, 14, 32, 25, 79 };
    display(arr);
    mergeSort(arr, 0, arr.length - 1);
    System.out.println("------");
    display(arr);
  }

  static void mergeSort(int la[], int left, int right) {
    int mid;
    if (left < right) {
      mid = (left + right) / 2;

      mergeSort(la, left, mid);
      mergeSort(la, mid + 1, right);

      merge(la, left, mid, right);
    }

  }

  static void merge(int ma[], int left, int mid, int right) {
    int low = mid - left + 1;
    int high = right - mid;

    // creating temorary sub-arrays
    int L[] = new int[low];
    int R[] = new int[high];

    // copying values into temporary subarrays

    for (int i = 0; i < low; i++) {
      L[i] = ma[left + i];
    }
    for (int j = 0; j < high; j++) {
      R[j] = ma[mid + 1 + j];
    }

    // for having current index of sub arrays
    int leftIndex = 0;
    int rightIndex = 0;

    // copy from L and R back into the array
    for (int i = left; i < right + 1; i++) {

      if (leftIndex < low && rightIndex < high) {
        if (L[leftIndex] < R[rightIndex]) {
          ma[i] = L[leftIndex];
          leftIndex++;
        } else {
          ma[i] = R[rightIndex];
          rightIndex++;
        }
      } else if (leftIndex < low) {
        // if all elements have been copied from R, copy rest of the L
        ma[i] = L[leftIndex];
        leftIndex++;
      } else if (rightIndex < high) {
        // if all elements have been copied from R, copy rest of the L
        ma[i] = R[rightIndex];
        rightIndex++;
      }
    }

  }

  static void display(int brr[]) {
    for (int i = 0; i < brr.length; ++i) {
      System.out.print(brr[i] + " ");
    }
    System.out.println();
  }
}