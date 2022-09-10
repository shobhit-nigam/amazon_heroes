class FibMem {
  public static void main(String[] args) {
    int n = 6;
    int[] lookUpTable = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      lookUpTable[i] = -1;
    }
    System.out.println(fib(n, lookUpTable));
  }

  public static int fib(int n, int lookUpTable[]) {
    if (lookUpTable[n] == -1) {
      if (n <= 1) {
        lookUpTable[n] = n;
      } else {
        lookUpTable[n] = fib(n - 1, lookUpTable) + fib(n - 2, lookUpTable);
      }
    }
    return lookUpTable[n];
  }

}
