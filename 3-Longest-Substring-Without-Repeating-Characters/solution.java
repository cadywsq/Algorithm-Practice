public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        
        int p1 = 0;
        int maxLen = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                p1 = Math.max(charMap.get(c) + 1,p1);
            }
            maxLen = Math.max(maxLen, i-p1+1);
            charMap.put(c, i);
        }
        return maxLen;
    }
}