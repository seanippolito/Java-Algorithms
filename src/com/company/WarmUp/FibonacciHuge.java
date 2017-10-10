package WarmUp;

import java.util.*;

public class FibonacciHuge {

    static long getPisanoPeriod(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sequenceLen = 0;

        for (long i = 0; i < m * m; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = ((tmp_previous) + (previous)) % m;
            sequenceLen++;
            if(previous == 0 && current == 1){
                return n%(sequenceLen);
            }
        }

        return n;
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long res = n;

        for (long i = 1; i < n; ++i) {
            res = ((previous) + (current))%m;
            previous = current;
            current = res;
        }

        return res % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long seq = getPisanoPeriod(n, m);
        System.out.println(getFibonacciHugeNaive(seq, m));

    }
}

