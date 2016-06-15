public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int[] factorials = getFactorial(n);
        k--;
        getPermutation(nums, k, factorials, sb);
        return sb.toString();
    }
    
    private void getPermutation(List<Integer> nums, int k, int[] factorials, StringBuilder sb) {
        if (k < 0 || nums.size() == 0) {
            return;
        }
        int factorial = factorials[nums.size()-1];
        int index = k / factorial;
        sb.append(nums.get(index));
        nums.remove(index);
        getPermutation(nums, k-index*factorial, factorials, sb);
    }
    
    private int[] getFactorial(int n) {
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i-1] * i;
        }
        return factorials;
    }
}