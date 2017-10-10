import java.lang.reflect.Array;
import java.util.*;
import java.math.*;

// Not Completed, need to rework
public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        List<String> str = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            str.add(a[i]);
        }
        while(!str.isEmpty()){
            String maxDigit = "";
            for(String item : str) {
                if(IsGreaterOrEqual(item, maxDigit)) {
                    maxDigit = item;
                }
                result += maxDigit;
                str.remove(item);
            }
        }


//        char[] arr = result.toCharArray();
//        result = "";
//        Arrays.sort(arr);
//        for(int i = arr.length -1; i >= 0; i--){
//            result += arr[i];
//        }

        return result;
    }

    private static boolean IsGreaterOrEqual(String digit, String maxDigit) {
//        char lastDigit = digit.charAt(digit.length());
//        char lastMaxDigit = maxDigit.charAt(digit.length());
//
//        if(digit.length() < maxDigit.length()) {
//            int pad = maxDigit.length() - digit.length();
//            digit += String.format("%" + (pad) + "s", "").replace(" ", String.valueOf(lastDigit));
//
//        } else if (digit.length() > maxDigit.length()){
//            int pad = digit.length() - maxDigit.length();
//            maxDigit += String.format("%" + (pad) + "s", "").replace(" ", String.valueOf(lastMaxDigit));
//
//        }
        char[] dig = digit.toCharArray();
        char[] maxDig = maxDigit.toCharArray();

        for(int i = 0; i < Math.min(dig.length, maxDig.length); i++){
            if(dig[i] < maxDig[i]){
                return false;
            } else if (dig[i] > maxDig[i]) {
                return true;
            } else if (dig[i] == maxDig[i]){
                continue;
            }
        }
        if(dig.length < maxDig.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int n = scanner.nextInt();
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next();
            }
            System.out.println(largestNumber(a));
        }
    }
}

