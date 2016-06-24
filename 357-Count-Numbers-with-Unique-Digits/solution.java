public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        return solution2(n);
    }
    
    /**Solution1: DP
     * for k-digit number, unique count is 9*9*8*...*(9-k+2).
     */
     private int solution1(int n) {
         //count of unique numbers with n digits
         int numCount = 9;
         //number of unique digits left
         int availableDigits = 9;
         int result = 10;
         
         while (n-- > 1  && availableDigits > 0) {
             numCount *= availableDigits;
             result += numCount;
             availableDigits--;
         }
         return result;
     }
     
     /**Solution2: Backtrack
      * one by one append digits that hasn't been used yet, until reaches 10^n.
      */
      private int solution2(int n) {
          int max = (int) Math.pow(10, n);
          if (n > 10) {
              return solution2(10);
          }
          int count = 1; // n==0
          boolean[] used = new boolean[10];
          // the first digit from 1~9
          for (int i = 1; i <= 9; i++) {
              used[i] = true;
              count += getUniqueCount(i, max, used);
              used[i] = false;
          }
          return count;
      }
      
      private int getUniqueCount(int prev, int max, boolean[] used) {
          int count = 0;
          if (prev >= max) {
              return count;
          }
          count++;
          // besides first digit, all from 0~9 except for used ones
          for (int i = 0; i <= 9; i++) {
              if (!used[i]) {
                  int cur = prev*10 + i;
                  used[i] = true;
                  count += getUniqueCount(cur, max, used);
                  used[i] = false;
              }
          }
          return count;
      }
}