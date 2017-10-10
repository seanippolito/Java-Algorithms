package StringsAndArrays;

import java.util.Scanner;

public class RotateMatrix {
    public static void getRotateMatrix(int[][] mx, int n) {

        for(int layer = 0; layer < n/2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = mx[first][i];
                mx[first][i] = mx[last-offset][first];
                mx[last-offset][first] = mx[last][last-offset];
                mx[last][last-offset] = mx[i][last];
                mx[i][last] = top;
            }
        }
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] matrix = new int[n][n];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                matrix[r][c] = kb.nextInt();
            }
        }
        getRotateMatrix(matrix, n);
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
