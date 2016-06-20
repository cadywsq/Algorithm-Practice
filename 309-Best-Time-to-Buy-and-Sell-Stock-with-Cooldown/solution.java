public class Solution {
    // Due to cooldown day requirement, day i-1 action has an impact on day i action.
    // Therefore, below solution categorize day i profit by day i-1 action.
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // day i-1 scenarios:
        //1. has 0 stock and buy 1
        //2. has 0 stock and rest
        //3. has 1 stock and sell 1 (day i must rest)
        //4. has 1 stock and rest
        // the current day profit under certain action are initialized as below
        int has0_buy = -prices[0];
        int has0_rest = 0;
        int has1_sell = 0;
        int has1_rest = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            // if has 0 and buy today, must had 0 and rest last day
            int temp_has0_buy = has0_rest - prices[i];
            // if has 0 and rest today, must either had 0 and rest or had 1 and sold last day
            int temp_has0_rest = Math.max(has0_rest, has1_sell);
            // if has 1 and sell today, must either had 1 and rest or had 0 and bought 1 last day
            has1_sell = Math.max(has1_rest, has0_buy) + prices[i];
            // if has 1 and rest today, must either had 0 and bought or had 1 and rest last day
            has1_rest = Math.max(has0_buy, has1_rest);
            
            has0_buy = temp_has0_buy;
            has0_rest = temp_has0_rest;
        }
        return Math.max(has0_rest, has1_sell);
    }
}