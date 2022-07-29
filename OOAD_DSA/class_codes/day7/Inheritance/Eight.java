// final
class Eight {
  public static void main(String[] args) {
    Etihad obja = new Etihad();
    Etihad objb = new Etihad();
    obja.weight(8, 18);
    System.out.println("extra to be paid = " + obja.extra_cost());
    objb.weight(8, 18);
    System.out.println("extra to be paid = " + objb.extra_cost(5));
  }
}

class Etihad {
  final int max_hand_baggage = 7;
  final int max_check_in_baggage = 15;
  final int hand_baggage = max_hand_baggage;
  int check_in_baggage = 15;
  double extra_cost_h = 0;
  double extra_cost_c = 0;

  void weight(int h, int c) {
    // hand_baggage = h;java Eight
    check_in_baggage = c;
    if (check_in_baggage > max_check_in_baggage) {
      extra_cost_c = (check_in_baggage - max_check_in_baggage) * 750;
    }
  }

  final double extra_cost() {
    return extra_cost_c + extra_cost_h;
  }

  double extra_cost(double disc) {
    double extra = (extra_cost_c + extra_cost_h) * (1 - disc / 100);
    return extra;
  }
}

// error
class NewEtihad extends Etihad {
  double extra_cost(double disc) {
    return extra_cost_c + extra_cost_h;
  }
}