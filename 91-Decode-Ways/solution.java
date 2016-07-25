public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        
        // initialize
        int[] count = new int[n + 1];
        count[0] = 1;
        if (nums[0] > 0) {
            count[1] = 1;
        }
        
        // state
        for (int i = 2; i <= n; i++) {
            if (nums[i-1] > 0) {
                count[i] = count[i-1];
            }
            int twoDigits = 10 * nums[i-2] + nums[i-1];
            if (twoDigits >= 10 && twoDigits <= 26) {
                count[i] += count[i-2];
            }
        }
        return count[n];
    }
}