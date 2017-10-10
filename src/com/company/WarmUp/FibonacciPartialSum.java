package WarmUp;

import java.util.*;

import static WarmUp.FibonacciHuge.getPisanoPeriod;
import static WarmUp.FibonacciLastDigit.getFibonacciLastDigitNaive;
import static WarmUp.FibonacciSumLastDigit.getFibonacciSumNaive;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long res = 0;
        if(from == to) {
            long remainder = getPisanoPeriod(from, 10);
            res = getFibonacciLastDigitNaive(remainder);
            if (res < 0) {
                res = 9;
            }
            return res;
        }
        long sumFrom = getFibonacciSumNaive(from - 1);
        long sumTo = getFibonacciSumNaive(to);
        if(sumTo - sumFrom < 0){
            res = sumTo - sumFrom + 10;
        } else {
            res = sumTo - sumFrom;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();

        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

