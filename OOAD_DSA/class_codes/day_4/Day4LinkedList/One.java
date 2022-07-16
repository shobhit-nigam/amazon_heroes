import java.util.*;
class TiffinBox{
  
  int data;
  TiffinBox next;

  TiffinBox(int data){
    this.data = data;
    this.next = null;
  }
}




class One {

  TiffinBox start;

  void display(TiffinBox start)
  {
    TiffinBox temp = start;
    while(temp != null)
      {
        System.out.println(temp.data);
        temp = temp.next;
      }
  }

  TiffinBox insertBegin(int key, TiffinBox start)
  {
    TiffinBox temp = new TiffinBox(key);
    if (start == null){
      start = temp;
    }
    else{
      temp.next = start;
      start=temp;
    }
    return start;
  }

  
  TiffinBox append(int key, TiffinBox start)
  {
    TiffinBox temp = new TiffinBox(key);
    TiffinBox temp_other = start;

    if (temp_other ==  null)
    {
      start = temp;
    }
    else
    {
      while(temp_other.next != null)
        {
          temp_other = temp_other.next;
        }
      temp_other.next=temp;
    }
    return start;
  }
  
  
  public static void main(String[] args) {
    One o = new One();
    o.start = null;
    Scanner in = new Scanner(System.in);
    do {
  
    System.out.println("\n 1. Append at the End");
    System.out.println("\n 2. Insert at the beginning");
    System.out.println("\n 3. Display");
    int n = in.nextInt();
    switch(n)
      {
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
          o.display(o.start);
          break;
      }
    System.out.println("\nPress 1 to continue");
    }while(in.nextInt()==1);
    
  }
}

