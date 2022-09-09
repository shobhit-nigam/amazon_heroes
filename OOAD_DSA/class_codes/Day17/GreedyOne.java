import java.util.Arrays;
// given n pipes, connect these pipes into a single pipe
// cost of connecting two pipes is equal to sum of their lengths 
// 12, 9, 6, 18 (these are the lengths of the pipes)

class GreedyOne {
  public static void main(String[] args) {
    int[] pipes_a = { 12, 9, 6, 18 };
    // (21) + (21 + 6) + (48 + 18)
    // cost of house =48
    // spend_this_year = 21+9
    // total_spend = 21+27+48+66 = 162
    int[] pipes_b = { 3, 3, 6, 18 };
    // System.out.println("min cost for pipes_a =" + Pipes.minCost(pipes_a));
    System.out.println("direct cost for pipes_a =" + Pipes.directCost(pipes_a));

    // System.out.println("min cost for pipes_b =" + Pipes.minCost(pipes_b));
    System.out.println("direct cost for pipes_b =" + Pipes.directCost(pipes_b));
  }
}

class Pipes {

  Pipes() {
  }

  public static int minCost(int[] pipes_array) {
    int cost = 0;
    int n = pipes_array.length;
    for (int i = 0; i < n - 1; i++) {
      Arrays.sort(pipes_array);
      // 6 9 12 18
      // 6 12 15 18
      // 6 12 18 27
      int temp_cost = cost;
      cost = (pipes_array[i] + pipes_array[i + 1]);
      pipes_array[i + 1] = cost;
      // 6 15 12 18
      // 6 12 27 18
      // 6 12 27 45
      cost = cost + temp_cost;
      // System.out.println("cost = " + cost);
    }
    return cost;
  }

  public static int directCost(int[] pipes_array) {
    int cost = 0;
    int temp_cost = 0;
    int n = pipes_array.length;
    for (int i = 0; i < n - 1; i++) {
      temp_cost = cost;
      cost = (pipes_array[i] + pipes_array[i + 1]);
      cost = cost + temp_cost;
      pipes_array[i + 1] = cost;
    }
    return cost + temp_cost;
  }

}
