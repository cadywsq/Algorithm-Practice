public class Solution {
    /**similar to Problem Coin Change
     * the # of combinations of target: ways[target] = sum(ways[target - nums[i]]), 
     *      where 0 <= i < nums.length, and target >= nums[i]
     */
    public int combinationSum4(int[] nums, int target) {
        int[] ways = new int[target+1];
        ways[0] = 1;
        // i is contiguous target sum to build from bottom up till the target 
        for (int i = 1; i < ways.length; i++) {
            for (int num : nums) {
                if (num == i) {
                    ways[i] += 1;
                } else if (num < i) {
                    ways[i] += ways[i - num];
                } 
            }
        }
        return ways[target];
    }
    
    /**Top-down solution*/
    public int recursive(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int ways = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                ways += recursive(nums, target-nums[i]);
            }
        }
        return ways;
    }
}