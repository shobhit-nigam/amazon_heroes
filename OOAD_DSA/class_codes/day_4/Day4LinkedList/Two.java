import java.util.*;
class TiffinBox{
  
  String data;
  TiffinBox next;

  TiffinBox(String data){
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

  TiffinBox append(String key, TiffinBox start)
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
    System.out.println("\n 2. Display");
    int n = in.nextInt();
    switch(n)
      {
        case 1: 
          System.out.println("\n enter the value");
          String val = in.nextLine();
          o.append(val, o.start);
          break;

        case 2:
          o.display(o.start);
          break;
      }
    System.out.println("\nPress 1 to continue");
    }while(in.nextInt()==1);
    
  }
}

