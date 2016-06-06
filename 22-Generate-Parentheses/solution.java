public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        helper(n, 0, 0, "", result);
        return result;
    }
    
    private void helper(int n, int openCount, int closeCount, String item, List<String> result) {
        if (item.length() == n*2) {
            result.add(item);
            return;
        }
        
        if (openCount < n) {
            helper(n, openCount+1, closeCount, item + "(", result);
        }
        if (closeCount < openCount) {
            helper(n, openCount, closeCount+1, item + ")", result);
        }
    }
}
