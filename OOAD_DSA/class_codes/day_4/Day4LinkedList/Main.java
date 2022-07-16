class Main {
  public static void main(String[] args) {
    TiffinBox sat = new TiffinBox("chole bhature");
    System.out.println(sat.data);
  }
}

class TiffinBox{
  String data;
  TiffinBox next;

  TiffinBox(String d){
    this.data = d;
    this.next = null;
  }
}