import java.util.*;

class TotalNumSteps {
    public static int TotalSteps(int n) {
        System.out.println("n = " + n);
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        int r = TotalSteps(n-1);
        System.out.println("r = " + r);
        System.out.println("n after r = " + n);
        int b = TotalSteps(n-2) + r;
        System.out.println("b = " + b);
        int c = TotalSteps(n-3) + b;
        System.out.println("c = " + c);

        return c;
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(TotalSteps(n));
    }

}


