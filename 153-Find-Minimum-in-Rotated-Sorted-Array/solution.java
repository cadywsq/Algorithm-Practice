public class Solution {
    /**
     *                o  |                                  o
     *              o    |                                o
     *            o      |                             o
     *         o         |                           o
     *         --------------------                o
     *     start         |        o end          o
     *                   |      o              o
     *                   |   o              o
     *                   | o              o
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start)/2;
            // the rotate position has the smallest element of the whole rotated array.
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            // if mid falls into left part of the array
            if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                // if mid falls into right part of the array
                end = mid-1;
            }
        }
        return nums[start];
    }
}