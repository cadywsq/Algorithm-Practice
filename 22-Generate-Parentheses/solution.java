public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getResults(n, 0, 0, "", result);
        return result;
    }
    
    private void getResults(int n, int openCount, int closeCount, String s, List<String> result) {
        if (s.length() == n*2) {
            result.add(s);
            return;
        }
        
        if (openCount < n) {
            getResults(n, openCount+1, closeCount, s + '(', result);
        }
        // insert close bracket in each positions after open brackets
        if (closeCount < openCount) {
            getResults(n, openCount, closeCount+1, s + ')', result);
        }
    }
}