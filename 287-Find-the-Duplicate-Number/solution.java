public class Solution {
    public int findDuplicate(int[] nums) {
        return solution1(nums);
    }
    
    // O(N) time, O(1) space. 
    // Constraints: array can be modified; array length is longer than number range.
    private int solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }
        return -1;
    }
    
    // array not modified.
    private int solution2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}