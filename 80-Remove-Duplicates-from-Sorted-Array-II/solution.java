public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int newLen = 0;
        int dupLen = 0;
        int last = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (last == nums[i]) {
                dupLen++;
                if (dupLen > 2) {
                    continue;
                }
            } else {
                last = nums[i];
                dupLen = 1;
            }
            nums[newLen] = nums[i];
            newLen++;
            
        }
        return newLen;
    }
}