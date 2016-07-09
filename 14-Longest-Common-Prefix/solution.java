public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // i for traverse all characters in the first word, j for traverse array of words.
        for (int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != cur) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}