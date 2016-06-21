public class Solution {
    public int numSquares(int n) {
        int[] sqrNum = new int[n+1];
        sqrNum[1] = 1;
        
        for (int i = 1; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;
            
            for (int j = 1; j*j <= i; j++) {
             // For each i, it must be the sum of some number (i - j*j) and 
             // a perfect square number (j*j).
                minCount = Math.min(minCount, sqrNum[i-j*j] + 1);
            }
            sqrNum[i] = minCount;
        }
        return sqrNum[n];
    }
}