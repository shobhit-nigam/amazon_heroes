import java.util.*;

class TiffinBox {

  int data;
  TiffinBox next;

  TiffinBox(int data) {
    this.data = data;
  }
}

class Stack {

  void display(TiffinBox head) {
    System.out.println("\n stack data -->:");
    if (head==null){
      System.out.println("no Tiffinboxes");
    return; 
    }
    TiffinBox temp = head;
    while(temp!=null){
      System.out.println(temp.data);
      temp = temp.next;
    } 
  }

  TiffinBox push(int data, TiffinBox head) {
    TiffinBox temp = new TiffinBox(data);
    if (head == null) {
      head = temp;
    } else {
      temp.next = head;
      head = temp;
    }
    return head;
  }

  TiffinBox pop(TiffinBox head) {

    if (head == null) {
      System.out.println("stack is empty");
    } else {
      head = head.next;
    }
    return head;
  }

  boolean isEmpty(TiffinBox head){
    if (head == null){
      return true;
    }
    else{
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
class Two{
  public static void main(String[] args) {
    Stack objs = new Stack();
    TiffinBox head= null;
    Scanner in = new Scanner(System.in);
    do {

      System.out.println("\n 1. Push");
      System.out.println("\n 2. Pop");
      System.out.println("\n 3. Peek");
      System.out.println("\n 4. Is Empty = ");
      System.out.println("\n 5. Display");
      System.out.println("\n 6. exit");
      System.out.println("\n enter the choice");
      int n = in.nextInt();
      switch (n) {
        case 1:
          System.out.println("\n enter the value");
          int vala = in.nextInt();
          head = objs.push(vala, head);
          break;

        case 2:
          head = objs.pop(head);
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