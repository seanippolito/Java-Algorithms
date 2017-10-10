import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {

      long previous = 0;
      long current  = 1;
      long res = n;

      for (long i = 1; i < n; ++i) {
          res = ((previous) + (current));
          previous = current;
          current = res;
      }

    return res;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));

  }
}
