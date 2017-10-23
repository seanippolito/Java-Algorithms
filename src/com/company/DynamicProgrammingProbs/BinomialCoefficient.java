package com.company.DynamicProgrammingProbs;

import java.util.Arrays;
import java.util.Scanner;

public class BinomialCoefficient {
    public static int BC(int n, int k){
        int[][] cache = new int[n + 1][k + 1];
        int row, col;

        for(row = 0; row <= n; row++){
            for(col = 0; col <= Math.min(row, k); col++){
                if(col == 0 || col == row){
                    cache[row][col] = 1;
                } else {
                    cache[row][col] = cache[row-1][col-1] + cache[row-1][col];
                }
            }
        }

        return cache[n][k];
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        while(true) {
            int n = kb.nextInt();
            int k = kb.nextInt();
            System.out.println(BC(n, k));
        }
    }
}
