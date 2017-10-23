
import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int cache[][] = new int[s.length()+1][t.length()+1];
    for(int row = 0; row <= s.length(); row++) {
        for(int col = 0; col <= t.length(); col++){
            if(row == 0){
                cache[row][col] = col;
            } else if (col == 0){
                cache[row][col] = row;
            } else if(s.charAt(row-1) != t.charAt(col-1)){
                cache[row][col] = Math.min(Math.min(cache[row - 1][col - 1] + 1, cache[row - 1][col] + 1), cache[row][col - 1] + 1);
            } else {
                cache[row][col] = cache[row - 1][col - 1];
            }
        }
    }
    return cache[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
