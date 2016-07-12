public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;
       
        while (start < end) {
            int mid = start + (end-start)/2;
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[end]) {
                start = mid+1;
            } else if (nums[mid] < nums[end]) {
                // Attention: can't set end to mid-1 like in Problem 153, since mid can still be the target to find.
                end = mid;
            } else {
                end--;
            }
        }
        return nums[start];
    }
}