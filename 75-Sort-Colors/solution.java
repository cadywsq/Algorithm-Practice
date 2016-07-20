public class Solution {
    // example:[0,1,2,1,0,2,2]
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length-1;
        // red represent (count of red - 1), blue represent (count of blue - 1).
        for (int i = 0; i <= blue; i++) {
            while (nums[i] == 2 && i < blue) {
                swap(nums, i, blue);
                blue--;
            }
            // as after swap current blue with the latter element, current may become a red, which should be swapped with earlier element which may not be red, the order with above while loop cannot be switched.
            while (nums[i] == 0 && i > red) {
                swap(nums, i, red);
                red++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}