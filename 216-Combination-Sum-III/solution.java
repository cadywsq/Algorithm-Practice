public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0 || n <= 0) {
            return result;
        }
        getCombinations(k, 1, n, new ArrayList<>(), result);
        return result;
    }
    
    private void getCombinations(int k, int index, int n, List<Integer> ans, List<List<Integer>> result) {
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<>(ans));
            }
            return;
        }
        
        if (index > 9) {
            return;
        }
        
        ans.add(index);
        getCombinations(k-1, index+1, n-index, ans, result);
        ans.remove(ans.size()-1);
        
        getCombinations(k, index+1, n, ans, result);
    }
}