public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        // dp array representing count of unique numbers with n digits
        int[] uniqueCount = new int[n+1];
        uniqueCount[1] = 10;
        
        for (int i = 2; i <= n; i++) {
            uniqueCount[i] = uniqueCount[i-1] + getCount(i);
        }
        return uniqueCount[n];
    }
    
    private int getCount(int n) {
        int result = 9;
        for (int i = 0; i < n-1; i++) {
            result *= 9-i;
        }
        return result;
    }
}