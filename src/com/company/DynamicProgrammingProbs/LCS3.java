import java.util.*;

public class LCS3 {

    private static int lcs3(int[] left, int[] top, int[] depth) {
        //Write your code here
        int[][][] cache = new int[left.length+1][top.length+1][depth.length+1];
        for(int row = 0; row <= left.length; row++){
            for(int col = 0; col <= top.length; col++){
                for(int dep = 0; dep <= depth.length; dep++){
                    if(row == 0 || col == 0 || dep == 0){
                        cache[row][col][dep] = 0;
                    } else if(left[row - 1] == top[col - 1] && top[col - 1] == depth[dep - 1]) {
                        cache[row][col][dep] = cache[row - 1][col - 1][dep - 1] + 1;
                    } else {
                        cache[row][col][dep] = Math.max(Math.max(cache[row - 1][col][dep], cache[row][col - 1][dep]),
                                                        cache[row][col][dep - 1]);
                    }
                }
            }
        }

        return cache[left.length][top.length][depth.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

