public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int lowestPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        
        for (int i = 1; i < prices.length; i++) {
            lowestPrice = Math.min(lowestPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowestPrice);
        }
        return maxProfit;
    }
}