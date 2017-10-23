package com.company.DynamicProgrammingProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LCS {
    private static int LCSeq(int[] vals){
        int[] cache = new int[vals.length];
        Arrays.fill(cache, 1);

        for (int i = 1; i < vals.length; i++) {
            for (int j = 0; j < i; j++) {
                if(vals[j] < vals[i]){
                    cache[j]++;
                }
            }
        }
        for(int c : cache){
            System.out.println(c);
        }
        return Arrays.stream(cache).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] vals = new int[] {5, 6, 4, 7, 8};
        System.out.println(LCSeq(vals));
    }
}
