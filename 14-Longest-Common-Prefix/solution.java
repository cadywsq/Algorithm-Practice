public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String largest = strs[0];
        String smallest = strs[0];
        for (String str : strs) {
            if (str.compareTo(largest) > 0) {
                largest = str;
            } else if (str.compareTo(smallest) < 0) {
                smallest = str;
            }
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < Math.min(largest.length(), smallest.length()); i++) {
            char c = largest.charAt(i);
            if (c == smallest.charAt(i)) {
                prefix.append(c);
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }
}