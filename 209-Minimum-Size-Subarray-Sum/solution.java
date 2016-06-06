public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        
        while (i < nums.length) {
            sum += nums[i++];
            
            while (sum >= s) {
                minLen = Math.min(minLen, i-j);
                sum -= nums[j++];
            }  
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}