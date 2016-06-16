public class Solution {
    public int maxSubArray(int[] nums) {
        return solution1(nums);
    }
    
    /**Solution1: Kadane's Algorithm
     * 1.look for all positive contiguous segments of the array (max_ending_here). 
     * 2.Keep track of maximum sum contiguous segment among all positive segments (max_so_far). 
     * 3.Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
     */
     private int solution1(int[] nums) {
         int curMax = 0; // as subarray needs to have at least one element.
         int max = Integer.MIN_VALUE;
         
         for (int i = 0; i < nums.length; i++) {
             curMax = Math.max(curMax + nums[i], nums[i]);
             max = Math.max(curMax, max);
         }
         return max;
     }
     
     /**Solution2: keep track of minSum till current position, 
      * then max subarray sum is MAX(max, curSum-minSum)
      */
      private int solution2(int[] nums) {
         int minSum = 0;
         int curSum = 0;
         int max = Integer.MIN_VALUE;
         for (int i = 0; i < nums.length; i++) {
             curSum += nums[i];
             max = Math.max(max, curSum-minSum);
             minSum = Math.min(minSum, curSum);
         }
         return max;
      }
}