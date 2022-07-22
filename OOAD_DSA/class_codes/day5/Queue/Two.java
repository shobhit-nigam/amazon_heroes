import java.util.*;

class TiffinBox {

  int data;
  TiffinBox next;

  TiffinBox(int data) {
    this.data = data;
  }
}

class Queue {

  void display(TiffinBox head) {
    System.out.println("\n queue data -->:");
    if (head == null) {
      System.out.println("no nodes");
      return;
    }
    TiffinBox temp = head;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  TiffinBox enqueue(int data, TiffinBox head) {
    TiffinBox temp = new TiffinBox(data);
    if (head == null) {
      head = temp;
    } else {
      TiffinBox temp_b = head;
      while (temp_b.next != null) {
        temp_b = temp_b.next;
      }
      temp_b.next = temp;
    }
    return head;
  }

  TiffinBox deque(TiffinBox head) {

    if (head == null) {
      System.out.println("queue is empty");
    } else {
      head = head.next;
    }
    return head;
  }

  boolean isEmpty(TiffinBox head) {
    if (head == null) {
      return true;
    } else {
      return false;
    }
  }

  int peek(TiffinBox head) {

    if (head == null) {
      System.out.println("stack is empty");
      return -1;
    }
    return head.data;
  }
}

class Two {
  public static void main(String[] args) {
    Queue objs = new Queue();
    TiffinBox head = null;
    Scanner in = new Scanner(System.in);
    do {

      System.out.println("\n 1. Push");
      System.out.println("\n 2. Pop");
      System.out.println("\n 5. Display");
      System.out.println("\n 6. exit");
      System.out.println("\n enter the choice");
      int n = in.nextInt();
      switch (n) {
        case 1:
          System.out.println("\n enter the value");
          int vala = in.nextInt();
          head = objs.enqueue(vala, head);
          break;

        case 2:
          head = objs.deque(head);
          break;

        case 3:
          System.out.println("\n top element =" + objs.peek(head));
          break;

        case 4:
          System.out.println("\n is empty = " + objs.isEmpty(head));
          break;

        case 5:
          objs.display(head);
          break;

        case 6:
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