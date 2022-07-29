import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Etihad flight_one = new Etihad();
    flight_one.book();
    System.out.println("--calling booking again for another guest---");
    flight_one.book();
    System.out.println("--calling booking again for another guest---");
    flight_one.book();
    System.out.println("total " + flight_one.total_booking() + " seats booked");
  }
}

class Etihad {
  int max_rows = 4;
  int max_cols = 4;
  Seat[][] total = new Seat[max_rows][max_cols];

  Etihad() {
    for (int i = 0; i < max_rows; i++) {
      for (int j = 0; j < max_cols; j++) {
        total[i][j] = new Seat();
      }
    }
  }

  void show_layout() {
    System.out.println("\n");
    for (int i = 0; i < max_rows; i++) {
      for (int j = 0; j < max_cols; j++) {
        if (j == 2) {
          System.out.print("\t");
        }
        System.out.print(total[i][j].booking_status() + "  ");
      }
      System.out.println("\n");
    }
  }

  int total_booking() {
    int book = 0;
    for (int i = 0; i < max_rows; i++) {
      for (int j = 0; j < max_cols; j++) {
        if (total[i][j].booking_status().equals("booked")) {
          book++;
        }
      }
    }
    return book;
  }

  void book() {
    while (true) {
      show_layout();
      System.out.println("enter your preferred row:");
      Scanner pref = new Scanner(System.in);
      int row = pref.nextInt();
      System.out.println("enter your column:");
      int col = pref.nextInt();
      // pref.close();
      if (total[row][col].info[0] == "booked") {
        System.out.println("sorry, please book another seat");
      } else {
        total[row][col].info[0] = "booked";
        break;
      }
    }
  }
}

class Seat {
  // String[] info = new String[2];
  String[] info = new String[] { "empty", "no meals" };

  Seat() {
    this.info[0] = "empty";
    this.info[1] = "no meals";
  }

  String all_info() {
    return "this seat is " + this.info[0] + " " + this.info[1];
  }

  String booking_status() {
    return this.info[0];
  }

  String food_status() {
    return this.info[1];
  }
}