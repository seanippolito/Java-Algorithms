package StringsAndArrays;

import OOP.MaxPairwiseProduct;

import java.util.Scanner;

public class IsUnique {
    static private boolean getIsUnique(String str){
        boolean[] hasChar = new boolean[26];
        for(int j = 0; j < hasChar.length - 1; ++j){
            hasChar[j] = false;
        }

        for(int i = 0; i < str.length(); ++i){

            int idx = Character.getNumericValue(str.toLowerCase().charAt(i)) - Character.getNumericValue('a');
            if(hasChar[idx]) {
                return false;
            }
            hasChar[idx] = true;
        }
        return true;
    }

    static private boolean bitIsUnique(String str){
        int checker = 0;

        for(int i = 0; i < str.length(); ++i){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0 ) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
//        int[] numbers = new int[n];
//        for(int i = 0; i < n; i++){
//            numbers[i] = scanner.nextInt();
//        }
        System.out.println(getIsUnique(str));
        System.out.println(bitIsUnique(str));

    }
}
