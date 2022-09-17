interface Payment {
  public void transaction(int amount);
}

class Money implements Payment {
  public void transaction(int amount) {
    // transaction with money
  }
}

class DebitCard implements Payment {
  public void transaction(int amount) {
    // transaction with Debit card
  }
}

class UPI implements Payment {
  public void transaction(int amount) {
    // transaction with UPI
  }
}

class CreditCard implements Payment {
  public void transaction(int amount) {
    // transaction with Credit card
  }
}

public class Shopping {
  private Payment p;

  public Shopping(Payment px) {
    this.p = px;
  }

  public void pay(int amount) {
    p.transaction(amount);
  }

  public static void main(String args[]) {
    Payment p = new Money();
    Shopping s = new Shopping(p);
    s.pay(1000);
  }
}