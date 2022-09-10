class FibTab {
  public static void main(String[] args) {
    int n = 6;
    int[] lookUpTable = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      lookUpTable[i] = -1;
    }
    System.out.println(fib(n, lookUpTable));
  }

  public static int fib(int n, int lookUpTable[]) {
    lookUpTable[0] = 0;
    lookUpTable[1] = 1;

    for (int i = 2; i<=n; i++)
      {
        lookUpTable[i] = lookUpTable[i-1] + lookUpTable[i-2];
      }
    return lookUpTable[n];
  }

}
