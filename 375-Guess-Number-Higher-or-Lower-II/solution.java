public class Solution {
    /**
     * Given any n, we make a guess k. Then we break the interval [1,n] into [1,k - 1] and [k + 1,n]. The min of worst case cost can be calculated recursively as
     *      cost[1,n] = k + max{cost[1,k - 1], cost[k+1,n]}
     * "min of max cost" means you strategy is the best, but your luck is the worst. 
     * You only guess right when there is no possibilities to guess wrong.
     */
    public int getMoneyAmount(int n) {
        // definition: min amount of money to win subproblem [i~j]
        int[][] minCost = new int[n+1][n+1];
        // initialize: minCost[i][i] = 0
        for (int i = 1; i < n; i++) {
            minCost[i][i+1] = i;
        }
        // state
        for (int j = 2; j <= n; j++) {
            for (int i = j-1; i >= 1; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
                    int localMax = k + Math.max(minCost[i][k-1], minCost[k+1][j]);
                    // this min makes sure that you are minimizing your cost.
                    globalMin = Math.min(globalMin, localMax);
                }
                if (minCost[i][j] == 0) {
                    minCost[i][j] = globalMin;
                }
            }
        }
        return minCost[1][n];
    }
}