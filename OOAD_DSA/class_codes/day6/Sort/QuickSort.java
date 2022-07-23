class QuickSort {
  public static void main(String[] args) {
    int arr[] = { 88, 14, 32, 25, 79 };
    display(arr);
    quickSort(arr, 0, arr.length - 1);
    System.out.println("------");
    display(arr);
  }

  static void quickSort(int[] qa, int begin, int end){
    int pivot;
    if(begin < end){
      pivot = partition(qa, begin, end);
      quickSort(qa, begin, pivot-1);
      quickSort(qa, pivot+1, end);
    }
  }

  static int partition(int[] pa, int begin, int end){
    int pivot = end;

    int count = begin;
    for (int i = begin; i<end; i++){
      if(pa[i] < pa[pivot]){
        int temp = pa[count];
        pa[count] = pa[i];
        pa[i] = temp;
        count++;
      }
    }
    int temp = pa[pivot];
    pa[pivot] = pa[count];
    pa[count] = temp;
    
    return count;
  }
  
  static void display(int brr[]) {
    for (int i = 0; i < brr.length; ++i) {
      System.out.print(brr[i] + " ");
    }
    System.out.println();
  }
}