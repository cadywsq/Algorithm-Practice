public class Solution {
    
    /** Find a position i, such that (nums[i+1],nums[i+2],...,nums[n-1]) is descending and (nums[i],nums[i+1],...,nums[n-1]) is not descending.
     * So we cannot make (nums[i+1],nums[i+2],...,nums[n-1]) larger by reorder it.
     * Then, in (nums[i+1],nums[i+2],...,nums[n-1]), we find the least number that is larger than nums[i], and swap them.
     * Finally, reverse (nums[i+1],nums[i+2],...,nums[n-1]).
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                
                //Find a position i, such that (nums[i+1],nums[i+2],...,nums[n-1]) is descending
                //and (nums[i],nums[i+1],...,nums[n-1]) is not descending.
                for (int j = nums.length-1; j >= i; j--) {
                    
                    //we find the least number that is larger than nums[i]
                    if (nums[j] > nums[i-1]) {
                        swap(nums, j, i-1);
                        reverse(nums, i, nums.length-1);
                        return;
                    }
                }
            }
        }
        //The whole array is sorted descending, reverse it.
        reverse(nums, 0, nums.length-1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}