package StringsAndArrays;

import java.util.Scanner;

/*
 * There are three types of edits that can be performed on strings: insert a
 * character. remove a character, or replace a character. Given two strings,
 * write a function to check if they are one edit(or zero edits) away.
 */
public class OneAway {
    public static boolean getOneAway(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        char[] larger;
        char[] smaller;
        boolean foundOne = false;
        if(str1.length() > str2.length()) {
            larger = str1.toCharArray();
            smaller = str2.toCharArray();
        } else {
            larger = str2.toCharArray();
            smaller = str1.toCharArray();
        }

        //case 1 check if same length than compare
        if(larger.length == smaller.length || larger.length == (smaller.length + 1)) {
            for(int i = 0; i < smaller.length; i++){
                if(larger[i] != smaller[i]) {
                    if(foundOne){
                        return false;
                    }
                    foundOne = true;
                }
                if(foundOne && larger.length > smaller.length) {
                    return false;
                }
            }
        }

//        //case 2 remove or insert, just swap larger string
//        if(chaArr1.length == (chaArr2.length + 1) || chaArr2.length == (chaArr1.length + 1)){
//            if(chaArr1.length > chaArr2.length) {
//                larger = chaArr1;
//                smaller = chaArr2;
//            } else {
//                larger = chaArr2;
//                smaller = chaArr1;
//            }
//            for(int i = 0; i < larger.length; i++){
//                if(chaArr1[i] != chaArr2[i]) {
//                    if(foundOne){
//                        return false;
//                    }
//                    foundOne = true;
//                }
//            }
//        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while(true) {
            String str1 = scanner.next();
            String str2 = scanner.next();

            System.out.println(getOneAway(str1, str2));
//        }
    }
}
