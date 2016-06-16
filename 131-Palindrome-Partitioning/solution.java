public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        // cache[i][j] represents whether s.substring(i,j) is palindrome.
        boolean[][] cache = new boolean[s.length()][s.length()+1];
        partition(s, 0, new ArrayList<>(), result, cache);
        return result;
    }
    
    private void partition(String s, int index, List<String> part, List<List<String>> result, boolean[][] cache) {
        if (index == s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }
        // i represents the end of the substring.
        for (int i = index+1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (cache[index][i] || isPalindrome(substring)) {
                cache[index][i] = true;
                part.add(substring);
                // for recursion call, index change to i as substring starts from index+1.
                partition(s, i, part, result, cache);
                part.remove(part.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[chars.length-1-i]) {
                return false;
            }
        }
        return true;
    }
}