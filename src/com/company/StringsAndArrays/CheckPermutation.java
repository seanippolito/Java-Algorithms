package StringsAndArrays;

import java.util.HashMap;
import java.util.*;

public class CheckPermutation {

    static private boolean getCheckPermutation(String str1, String str2) {
        Map<Character, Integer> cache = new HashMap<>();
        if(str1.length() != str2.length()) {
            return false;
        }

        for(int i = 0; i < str1.length(); ++i){
            Character key = str1.charAt(i);
            if(cache.containsKey(key)) {
                int val = cache.get(key) + 1;
                cache.put(key, val);
            } else {
                cache.put(key, 1);
            }
        }

        for(int j = 0; j < str2.length(); j++) {
            Character key = str2.charAt(j);
            if(cache.containsKey(key)) {
                int val = cache.get(key);
                if(val == 0) {
                    return false;
                } else {
                    val--;
                }
                cache.put(key, val);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        System.out.println(getCheckPermutation(str1, str2));
    }

}
