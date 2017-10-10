package StringsAndArrays;

/*
 * Given a string, write a function to check if it's a permutation of a palindrome. A palindrome is a word
 * or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The
 * palindrome does not need to be limited to just dictionary words.
 * input: Tact Coa
 * Output: True (contains "taco cat", "atco cta", etc.)
 */


import java.util.Scanner;

public class PalindromePermutation {
    public static boolean getPalindromePermutation(String str){

        char[] charArr = str.toCharArray();
        int[] arr = new int[256];
        boolean flag = false;

        for(int i : charArr){
            arr[i]++;
        }
        for(int j : arr){
            if((j%2) == 1) {
                if(flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }

    public static boolean bitPalindromePermutation(String str){
        int bitVector = 0;

        for(int i : str.toCharArray()){
            int mask = 1 << i;
            if((bitVector & mask) == 0) {
                bitVector |= mask;
            } else {
                bitVector &= ~mask;
            }
        }
        return (bitVector == 0 || ((bitVector & (bitVector - 1)) == 0));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String str = scanner.next();
            System.out.println(getPalindromePermutation(str));
            System.out.println(bitPalindromePermutation(str));
        }
    }
}
