
// array based stack with display
import java.util.*;

class One {
  public static void main(String[] args) {
    Stack objs = new Stack();
    Scanner in = new Scanner(System.in);
    do {
      System.out.println("\n 1. Push");
      System.out.println("\n 2. Pop");
      System.out.println("\n 3. Peek");
      System.out.println("\n 4. Is Empty");
      System.out.println("\n 5. Exit");
      System.out.println("\n enter the choice");
      switch (in.nextInt()) {
        case 1:
          System.out.println("\nenter the value");
          objs.push(in.nextInt());
          break;
        case 2:
          System.out.println("\npopped element is " + objs.pop());
          break;
        case 3:
          System.out.println("\ntopmost element is " + objs.peek());
          break;
        case 4:
          System.out.println("\nis empty = " + objs.isEmpty());
          break;
        case 5:
          System.out.println("\nexiting now");
          System.exit(0);
          break;
        default:
          System.out.println("\nwrong input");
          break;
      }
      System.out.println("\npress 1 to continue");
    } while (in.nextInt() == 1);
  }
}

// Stack using an array

class Stack {
  int[] arr;
  int top;

  Stack() {
    arr = new int[100];
    top = -1;
  }

  void push(int x) {
    if (top == arr.length - 1) {
      System.out.println("stack is full");
    } else {
      ++top;
      arr[top] = x;
    }
  }

  int pop() {
    if (top == -1) {
      System.out.println("stack is empty");
      return -1;
    } else {
      return (arr[top--]);
    }
  }

  boolean isEmpty() {
    if (top == -1) {
      return true;
    } else {
      return false;
    }
  }

  int peek() {
    if (top == -1) {
      System.out.println("stack is empty");
      return -1;
    } else {
      return (arr[top]);
    }
  }

  void display() {

    for (int i = 0; i <= top; i++) {
      System.out.println(arr[i]);
    }
  }
}