public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        
        int maxLen = 1;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            // check whether the current is the start of a consecutive sequence.
            if (!numSet.contains(curr-1)) {
                while (numSet.contains(++curr)) {
                    numSet.remove(curr);
                    count++;
                }
                maxLen = Math.max(maxLen, count);
                count = 1;
            }
        } 
        
        return maxLen;
    }
}