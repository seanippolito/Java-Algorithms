import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int temp = 0;
        for(int i = 1; i <= n; i++) {
            if(i <= n) {
                summands.add(i);
                n -= i;
            }
        }
        if(n > 0) {
            temp = summands.get(summands.size() - 1);
            summands.remove(summands.size() - 1);
            summands.add(temp + n);
            n -= n;
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int n = scanner.nextInt();
            List<Integer> summands = optimalSummands(n);
            System.out.println(summands.size());
            for (Integer summand : summands) {
                System.out.print(summand + " ");
            }
        }
    }
}

