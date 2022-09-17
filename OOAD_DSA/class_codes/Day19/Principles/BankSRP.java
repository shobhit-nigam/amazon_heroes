class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}

class Bank {
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

class Authentication {
  void sendOTP(String method) {
    if (method.equals("phone")) {
      // code for sending OTP on phone number
    } else if (method.equals("email")) {
      // code for sending OTP on phone number
    }
  }

}