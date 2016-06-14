public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combination(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void combination(int[] candidates, int target, int index, List<Integer> ans, List<List<Integer>> result) {
        if (index == candidates.length || target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        ans.add(candidates[index]);
        combination(candidates, target-candidates[index], index, ans, result);
        ans.remove(ans.size()-1);
        
        if (index < candidates.length-1 && candidates[index] == candidates[index+1]) {
            index++;
        }
        combination(candidates, target, index+1, ans, result);
        
    }
}