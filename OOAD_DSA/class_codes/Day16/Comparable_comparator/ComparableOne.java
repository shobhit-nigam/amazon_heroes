
class ComparableOne implements Comparable<ComparableOne> {
  char ch;
  int val;

  public ComparableOne(char ch, int val) {
    this.ch = ch;
    this.val = val;
  }

  public int compareTo(ComparableOne obja) {
    if (this.val == obja.val) {
      return 0;
    } else {
      return this.val > obja.val ? 1 : -1;
    }
  }

  public static void main(String[] args) {
    ComparableOne obje = new ComparableOne('e', 101);
    ComparableOne objE = new ComparableOne('E', 69);

    int return_val = obje.compareTo(objE);

  }
}