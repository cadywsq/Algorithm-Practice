public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        getSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void getSubsets(int[] nums, int start, List<Integer> ans, List<List<Integer>> result) {
        result.add(new ArrayList<>(ans));
        
        if (start == nums.length) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            ans.add(nums[i]);
            getSubsets(nums, i+1, ans, result);
            ans.remove(ans.size()-1);
        }
    }
}