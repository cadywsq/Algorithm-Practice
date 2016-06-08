public class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
         for (int i = 0; i < nums.length; i++) {
             if (i <= farthest && nums[i]+i > farthest) {
                 farthest = i + nums[i];
             }
         }
         return farthest >= nums.length-1;
    }
    /**
     * Solution 1: Greedy
     * Imagine nums[i] represents an interval which starts at i and length is nums[i],
     *   our task is to check if after merging all the intervals, whether it can reach end of array.
     * Maintain a variable to record farthest position we can reach, traverse array to update the variable,
     *   finally compare it with array's last index.
     */
     private boolean greedySolution(int[] nums) {
         int farthest = 0;
         for (int i = 0; i < nums.length; i++) {
             if (i <= farthest && nums[i]+i > farthest) {
                 farthest = i + nums[i];
             }
         }
         return farthest >= nums.length-1;
     }
     
      /**
     * Solution 2: DP
     * state: f[i] denotes we can reach index i
     * function: f[i]=true if exists 0<=j<i s.t. f[j]=true && j+nums[j]>=i
     * initialize: f[0]=true
     * answer: f[n-1]
     */
     private boolean dpSolution(int[] nums) {
         if (nums == null || nums.length == 0) {
             throw new AssertionError();
         }
         int n = nums.length;
         boolean[] canReach = new boolean[n];
         canReach[0] = true;
         
         for (int i = 1; i < n; i++) {
             for (int j = i-1; j >= 0; j--) {
                 if (canReach[j] && j+nums[i] >= i) {
                     canReach[i] = true;
                     break;
                 }
             }
         }
         return canReach[n-1];
     }

}