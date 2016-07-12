public class Solution {
    // worst case O(n) time complexity
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        // Attention: as each iteration change the index of start and end, base case is when new mid value equals target, so loop should stop when start > end to prevent missing the final check when start == end.
        while (start <= end) { 
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else if (nums[mid] < nums[start]) {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                start++;
            }
        }
        return false;
    }
}