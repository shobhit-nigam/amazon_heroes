// final
class Seven {
  public static void main(String[] args) {
    NewEtihad obja = new NewEtihad();
    obja.weight(8, 18);
    System.out.println("extra to be paid = " + obja.extra_cost());
  }
}

final class Etihad {
  final int max_hand_baggage = 7;
  final int max_check_in_baggage = 15;
  final int hand_baggage = max_hand_baggage;
  int check_in_baggage = 15;
  int extra_cost_h = 0;
  int extra_cost_c = 0;

  void weight(int h, int c) {
    // hand_baggage = h;
    check_in_baggage = c;
    if (check_in_baggage > max_check_in_baggage) {
      extra_cost_c = (check_in_baggage - max_check_in_baggage) * 750;
    }
    if (hand_baggage > max_hand_baggage) {
      extra_cost_h = (hand_baggage - max_hand_baggage) * 350;
    }
  }

  final double extra_cost() {
    return extra_cost_c + extra_cost_h;
  }

}

// error
class NewEtihad extends Etihad {
}