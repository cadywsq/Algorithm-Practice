public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 0;
        int high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!isPrefix(strs, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return strs[0].substring(0, (low+high)/2);
    }
    
    public boolean isPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}