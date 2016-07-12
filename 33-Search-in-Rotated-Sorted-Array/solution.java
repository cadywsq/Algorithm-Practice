public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            }
            // if mid falls in left part of the rotated array
            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && nums[mid] > target) {
                    // if target falls in left side of mid
                    end = mid-1;
                } else {
                    // if target falls in right side of mid
                    start = mid+1;
                }
            } else {
                if (target <= nums[end] && nums[mid] < target) {
                    // if target falls in right side of mid
                    start = mid+1;
                } else {
                    // if target falls in left side of mid
                    end = mid-1;
                }
            }
        }
        return nums[start] == target ? start : -1;
    }
}