import java.util.*;

public class DotProduct {
    private static long maxDotProduct(long[] a, long[] b) {
        //write your code here
        long result = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            long temp = (long)a[i] * (long)b[i];
             result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(maxDotProduct(a, b));
        }
    }
}

