class Four {
  public static void main(String[] args) {
    int arr[] = {10, 20, 30, 40, 50, 60};
    int brr[];
    System.out.println("arr -->");
    display(arr);
    brr = modifyValues(arr.clone());
    System.out.println("brr -->");
    display(brr);

  }
// crr = arr.clone()
  static int [] modifyValues(int crr[])
  {
    for(int i=0; i<crr.length; i++)
      {
        crr[i] = crr[i] - 4;
      }  
      System.out.println("crr's changed values:");
    return crr;
    
  }


  
  static void display(int xrr[]){
    for(int i=0; i<xrr.length; i++)
      {
        // i=0, arr[0] 
        // i=1, arr[1] = 20
        System.out.println(xrr[i]);
      }    
  }
}