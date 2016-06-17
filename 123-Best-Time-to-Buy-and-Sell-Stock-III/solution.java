public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] firstTransProfit = new int[n];
        int[] secondTransProfit = new int[n];
        
        int lowestPrice = prices[0];
        // firstTransProfit[i] to track the maximum profit for transactions before i
        // i represents the max profit for sell or not sell at day i.
        for (int i = 1; i < n; i++) {
            lowestPrice = Math.min(lowestPrice, prices[i]);
            firstTransProfit[i] = Math.max(firstTransProfit[i-1], prices[i] - lowestPrice);
        }
        
        
        int highestPrice = prices[n-1];
        // secondTransProfit[i] to track the maximum profit for transactions after i
        // i represents the max profit for buy or not buy at day i.
        for (int i = n-2; i >= 0; i--) {
            highestPrice = Math.max(highestPrice, prices[i]);
            secondTransProfit[i] = Math.max(secondTransProfit[i+1], highestPrice - prices[i]);
        }
        
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, firstTransProfit[i] + secondTransProfit[i]);
        }
        return maxProfit;
    }
}