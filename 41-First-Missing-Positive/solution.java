public class Solution {
    /**
     * Use the thinking of bucket sort, but do not use extra space.
     * Since we are looking for positive, we can store x in nums[x-1].
     * Go through the array, if a number x is in range of [1,n], swap it to x-1.
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //Note that the number in nums[i]-1 may be equal to i, we should check it otherwise it will be a infinite loop.
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}