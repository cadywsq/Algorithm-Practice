public class Solution {
    public List<List<String>> partition(String s) {
        return dfsSolution(s);
    }
    
    // DFS solution: partition the string to check whether first part is palindrome, then recursively partition the second part.
    // Time complexity: O(2^N), as there are 2^N partitions.
    private List<List<String>> dfsSolution(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        // record whether s.substring(i,j) is palindrome 
        boolean[][] dp = new boolean[s.length()][s.length()+1];
        partitionHelper(s, dp, new ArrayList<>(), result, 0);
        return result;
    }
    
    private void partitionHelper(String s, boolean[][] dp, List<String> element, List<List<String>> result, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(element));
            return;
        }
        
        for (int i = index+1; i <= s.length(); i++) {
            String str = s.substring(index, i);
            if (dp[index][i] || isPalindrome(str)) {
                dp[index][i] = true;
                element.add(str);
                // if current s substring is palindrome, recursively check the rest of s.
                partitionHelper(s, dp, element, result, i);
                element.remove(element.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i <= len/2; i++) {
            if (chars[i] != chars[len-1-i]) {
                return false;
            }
        }
        return true;
    }
}