package StringsAndArrays;

import java.util.Scanner;
/*
 * a method to preform basic string compression using the counts of repeated
 * characters. Example: aaabbbcddd = 3a3bc3d
 */
public class StringCompression {
    public static String getStringCompression(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();
        char temp = charArr[0];
        int count = 0;

        for(char l : charArr) {
            if(temp != l) {
                if(count > 1) {
                    sb.append(count);
                }
                sb.append(temp);
                temp = l;
                count = 1;
            } else {
                count++;
            }
        }
        if(count > 1) {
            sb.append(count);
        }
        sb.append(temp);

        return sb.length() >= str.length() ? str : sb.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(getStringCompression(str));
    }
}
