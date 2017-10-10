import java.util.*;

public class LCM {
    private static long gcd_naive(long a,long b) {
        if(b == 0) {
            return a;
        }

        return gcd_naive(b, a%b);
    }

  private static long lcm_naive(long a, long b) {
    if(a == 0 || b == 0){
        return 0;
    }
    return a * (b / gcd_naive(a, b));
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);

    long a = scanner.nextInt();
    long b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));

  }
}
