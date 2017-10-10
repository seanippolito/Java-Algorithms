import java.lang.reflect.Array;
import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double temp = 0;
        int idx = 0;

        for(int i = 0; i < values.length; i++){
            if(capacity == 0) { return value; }

            for(int j = 0; j < values.length; j++){
                double prev_temp = (double)values[j] / (double)weights[j];
                if (prev_temp > temp){
                    idx = j;
                    temp = prev_temp;
                }
            }
            temp = 0;

            if(capacity <= weights[idx]){
                value = value + (((double)capacity/weights[idx]) * values[idx]);
                return value;
            } else {
                capacity -= weights[idx];
                value += values[idx];
                values[idx] = 0;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int n = scanner.nextInt();
            int capacity = scanner.nextInt();
            int[] values = new int[n];
            int[] weights = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
                weights[i] = scanner.nextInt();
            }
            System.out.println(getOptimalValue(capacity, values, weights));
        }
    }
} 
