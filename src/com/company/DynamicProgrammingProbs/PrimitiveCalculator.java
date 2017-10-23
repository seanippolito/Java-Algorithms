
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        int[] cache = new int[n+1];

        for(int i = 1; i < cache.length; i++){
            cache[i] = cache[i-1] + 1;
            if(i % 2 == 0) {
                cache[i] = Math.min(cache[i/2] + 1, cache[i]);
            }
            if(i % 3 == 0){
                cache[i] = Math.min(cache[i/3] + 1, cache[i]);
            }
        }
        int j = n;
        while(j > 1){
            sequence.add(j);
            if(cache[j-1] == cache[j] - 1){
                j = j - 1;
            } else if(j % 2 == 0 && cache[j/2] == cache[j] - 1){
                j = j / 2;
            } else if(j % 3 == 0 && cache[j/3] == cache[j] - 1){
                j = j / 3;
            }
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    private static int MinNumMoves(int n) {
        return 5;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

