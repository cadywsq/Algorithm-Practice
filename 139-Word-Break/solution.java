public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        // canBeSegmented[i] represents s[0,i) can be segmented to words in dict.
        boolean[] canBeSegmented = new boolean[len+1];
        canBeSegmented[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                // if s[0,j) is can be segmented, and s[j,i) can be segmented, then s[0,i) is true.
                if (canBeSegmented[j] && wordDict.contains(s.substring(j,i))) {
                    canBeSegmented[i] = true;
                    break;
                }
            }
        }
        return canBeSegmented[len];
    }
}