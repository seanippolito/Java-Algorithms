import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //coins 1, 5, 10. Find minimum coins needed to make purchase
        int count = 0;
        while (m > 0) {
            if (m >= 10) {
                m -= 10;
                count++;
            } else if (m >= 5) {
                m -= 5;
                count++;
            } else {
                m -= 1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));


    }
}

