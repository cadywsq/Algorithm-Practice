public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] added = new boolean[nums.length];
        getPermutation(nums, added, new ArrayList<>(), result);
        return result;
    }
    
    private void getPermutation(int[] nums, boolean[] added, List<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (added[i]) {
                continue;
            }
            ans.add(nums[i]);
            added[i] = true;
            getPermutation(nums, added, ans, result);
            ans.remove(ans.size()-1);
            added[i] = false;
        }
    }
}