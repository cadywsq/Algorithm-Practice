public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n || n <= 0 || k <= 0) {
            return result;
        }
        getCombinations(n, k, 1, new ArrayList<>(), result);
        return result;
    }
    
    private void getCombinations(int n, int k, int start, List<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == k) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i <= n; i++) {
            ans.add(i);
            getCombinations(n, k, i+1, ans, result);
            ans.remove(ans.size()-1);
        }
    }
}