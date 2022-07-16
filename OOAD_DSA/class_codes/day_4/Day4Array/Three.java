class Three {
  public static void main(String[] args) {
    int arr[] = {10, 20, 30, 40, 50, 60};
    int brr[] = arr.clone();
    System.out.println("values before passing to modifcation method");
    display(arr);
    modifyValues(arr.clone());
    System.out.println("values after passing to modifcation method");
    display(arr);

  }
// crr = arr.clone()
  static void modifyValues(int crr[])
  {
    for(int i=0; i<crr.length; i++)
      {
        crr[i] = crr[i] - 4;
      }  
      System.out.println("crr's changed values:");
     display(crr);
    
  }


  
  static void display(int arr[]){
    for(int i=0; i<arr.length; i++)
      {
        // i=0, arr[0] 
        // i=1, arr[1] = 20
        System.out.println(arr[i]);
      }    
  }
}