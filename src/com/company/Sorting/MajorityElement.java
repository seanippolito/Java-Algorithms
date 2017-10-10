
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static List<Integer> merge(List<Integer> A, List<Integer> B) {
        int i = 0, j = 0;
        List<Integer> C = new ArrayList<>();
        while(!A.isEmpty() && !B.isEmpty()) {
            if(A.isEmpty()) {
                C.add(B.get(j));
                B.remove(j);
            }
            if(B.isEmpty()) {
                C.add(A.get(i));
                A.remove(i);
            }
            if(A.get(i) < B.get(j)) {
                C.add(A.get(i));
                A.remove(i);
            } else {
                C.add(B.get(j));
                B.remove(j);
            }
        }
        return C;
    }
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        int maj = 0, count = 1;
        for(int i = 1; i < a.length; i++) {
            if(a[maj] == a[i]) {
                count++;
            } else {
                count--;
                if (count == 0){
                    maj = i;
                    count = 1;
                }
            }
        }
        int newCount = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[maj] == a[i]) {
                newCount++;
            }
        }
        if(newCount > a.length/2) {
            return a[maj];
        }
        //write your code here
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

