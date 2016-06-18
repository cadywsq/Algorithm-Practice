public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }
    
    private int rob(int[] nums, int start, int end) {
        int len = end - start;
        
        int[] max = new int[len];
        max[0] = nums[start];
        max[1] = Math.max(nums[start], nums[start+1]);
        
        for (int i = start+2; i < end; i++) {
            max[i-start] = Math.max(max[i-start-2]+nums[i], max[i-start-1]);
        }
        return max[len-1];
    }
}