public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        getCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void getCombinations(int[] candidates, int target, int index, List<Integer> ans, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        
        if (index == candidates.length || target < 0) {
            return;
        }
        // use current value candidates[index]
        ans.add(candidates[index]);
        getCombinations(candidates, target-candidates[index], index+1, ans, result);
        ans.remove(ans.size()-1);
        
        // remove following duplicates
        while (index < candidates.length-1 && candidates[index] == candidates[index+1]) {
            index++;
        }
        // not using current value candidates[index]
        getCombinations(candidates, target, index+1, ans, result);
    }
}