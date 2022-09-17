class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}

class BankOCP {
  int deposit(int amount, String accnum) {
    // code for depositing the amount
    return 0;
  }

  int withdraw(int amount, String accnum) {
    // code for withdrawing the amount
    return 0;
  }

  void display() {
    // display the account balance
  }

  class Loan {
    void getLoan(String typeLoan) {
      if (typeLoan.equals("education")) {
        // some code
      } else if (typeLoan.equals("home")) {
        // some code
      } else if (typeLoan.equals("car")) {
        // some code
      }
    }

  }

  interface Authentication {
    public void sendOTP(String method);
  }

  class EmailAuthentication implements Authentication {
    public void sendOTP(String method) {
      // sending OTP on email
    }
  }

class PhoneAuthentication implements Authentication{
  public void sendOTP(String method) {
    // send OTP on phone
  }

}