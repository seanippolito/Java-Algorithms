package WarmUp;

import java.util.*;

import static WarmUp.FibonacciHuge.getPisanoPeriod;
import static WarmUp.FibonacciLastDigit.getFibonacciLastDigitNaive;

public class FibonacciSumLastDigit {
    static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long remainder = getPisanoPeriod(n+2, 10);
        long sumLastDigit = getFibonacciLastDigitNaive(remainder) - 1;
        if(sumLastDigit < 0) {
            sumLastDigit = 9;
        }
        return sumLastDigit;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

