public class Solution {
    public int missingNumber(int[] nums) {
        return solution2(nums);
    }
    
    // Math method.
    private int solution1(int[] nums) {
        int n = nums.length;
        int total = n * (n+1)/2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return total-sum;
    }
    
    // Bit method.
    private int solution2(int[] nums) {
        // key: initiating as length for the edge case.
        int missed = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missed = missed ^ nums[i] ^ i;
        }
        return missed;
    }
}