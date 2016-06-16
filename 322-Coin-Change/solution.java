public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        // to record for reaching each sum, the minimum number of coins needed.
        int[] minCount = new int[amount+1];
        
        // function: minCount[i] = MIN(minCount[i-coin]) + 1
        // i is from 1 to amount, bottom-up dynamic programming; coin is each coin value in coins[].
        for (int sum = 1; sum <= amount; sum++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (sum >= coin && minCount[sum-coin] != -1) {
                    min = Math.min(min, minCount[sum-coin] + 1);
                }
            }
            if (min == Integer.MAX_VALUE) {
                minCount[sum] = -1;
            } else {
                minCount[sum] = min;
            }
        }
        return minCount[amount];
    }
}