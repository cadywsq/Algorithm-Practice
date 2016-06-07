public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        partitionHelper(s, new ArrayList<>(), result, 0);
        return result;
    }
    
    private void partitionHelper(String s, List<String> element, List<List<String>> result, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(element));
            return;
        }
        
        for (int i = index+1; i <= s.length(); i++) {
            String str = s.substring(index, i);
            if (isPalindrome(str)) {
                element.add(str);
                // if current s substring is palindrome, recursively check the rest of s.
                partitionHelper(s, element, result, i);
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