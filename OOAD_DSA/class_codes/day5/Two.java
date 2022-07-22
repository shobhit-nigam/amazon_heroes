import java.util.*;

class TiffinBox {

  int data;
  TiffinBox next;

  TiffinBox(int data) {
    this.data = data;
    this.next = null;
  }
}

class Two {

  TiffinBox start;

  void display(TiffinBox start) {
    TiffinBox temp = start;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  TiffinBox insertBegin(int key, TiffinBox start) {
    TiffinBox temp = new TiffinBox(key);
    if (start == null) {
      start = temp;
    } else {
      temp.next = start;
      start = temp;
    }
    return start;
  }

  TiffinBox append(int key, TiffinBox start) {
    TiffinBox temp = new TiffinBox(key);
    TiffinBox temp_other = start;

    if (temp_other == null) {
      start = temp;
    } else {
      while (temp_other.next != null) {
        temp_other = temp_other.next;
      }
      temp_other.next = temp;
    }
    return start;
  }

  TiffinBox insertAtPosition(int key, int pos, TiffinBox start) {
    TiffinBox temp = new TiffinBox(key);
    if (pos == 1) {
      temp.next = start;
      start = temp;
    } else {
      TiffinBox temp_other = start;
      for (int i = 1; temp_other != null && i < pos; i++) {
        temp_other = temp_other.next;
      }
      temp.next = temp_other.next;
      temp_other.next = temp;
    }
    return start;
  }

  TiffinBox deleteAtPos(int pos, TiffinBox start) {
    TiffinBox temp = start;
    if (pos == 1) {
      start = temp.next;
    } else {
      for (int i = 1; temp != null && i < pos - 1; i++) {
        temp = temp.next;
      }
      temp.next = temp.next.next;
    }
    return start;
  }

  int displayLength(TiffinBox start) {
    TiffinBox temp = start;
    int l = 0;
    if (temp == null) {
      return 0;
    } else {
      while (temp != null) {
        temp = temp.next;
        l++;
      }
    }
    return l;
  }

  public static void main(String[] args) {
    Three o = new Three();
    o.start = null;
    Scanner in = new Scanner(System.in);
    do {

      System.out.println("\n 1. Append at the End");
      System.out.println("\n 2. Insert at the beginning");
      System.out.println("\n 3. Insert at a particular position");
      System.out.println("\n 4. Delete from a particular position");
      System.out.println("\n 5. Display the length");
      System.out.println("\n 6. Display all the values");
      System.out.println("\n 7. exit");
      int n = in.nextInt();
      switch (n) {
        case 1:
          System.out.println("\n enter the value");
          int vala = in.nextInt();
          o.start = o.append(vala, o.start);
          break;

        case 2:
          System.out.println("\n enter the value");
          int valb = in.nextInt();
          o.start = o.insertBegin(valb, o.start);
          break;

        case 3:
          System.out.println("\n enter the value");
          int valc = in.nextInt();
          int pos = in.nextInt();
          o.start = o.insertAtPosition(valc, pos, o.start);
          break;

        case 4:
          int pos_a = in.nextInt();
          o.start = o.deleteAtPos(pos_a, o.start);
          break;

        case 5:
          int len = o.displayLength(o.start);
          System.out.println("length is " + len);
          break;

        case 6:
          o.display(o.start);
          break;

        case 7:
          System.exit(0);
          break;

        default:
          System.out.println("wrong choice");
          break;
      }
      System.out.println("\nPress 1 to continue");
    } while (in.nextInt() == 1);

  }
}
