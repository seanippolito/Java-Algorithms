package Sorting;

import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();
    private static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        int x = a[l];
        int m1 = l;
        int m2 = r;
        int[] m = {m1, m2};
        for(int i = 0; i < r; i ++) {
            System.out.println(i + "th iteration");
            System.out.println(x + " = x value");
            System.out.println(a[i] + " = a[i]");
            if (a[i] < x ) {
                m1++;
                System.out.println(m1 + " = m1");
                System.out.println(a[m1] + " = a[m1]");
                swap(a, i, m1);
                System.out.println("after swap a[i] = " + a[i] + " a[m1] = " + a[m1]);
                m2++;
                swap(a, m1, m2);
            }else if (a[i] > x) {
                m2--;
                System.out.println(m2 + " = m2");
                System.out.println(a[m2] + " = m2");
                swap(a, i, m2);
                System.out.println("after swap a[i] = " + a[i] + " a[m2] = " + a[m2]);
                //i--;
            }
        }
        swap(a, l, m1);
        m[0] = m1;
        m[1] = m2;
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                j++;
                swap(a, i, j);
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1]+1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

