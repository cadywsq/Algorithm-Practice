public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) {
            return false;
        }
        // represent s.substring(0, i) can be found in dict.
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int j = i - word.length();
                if (j < 0) continue;
                if (canBreak[j] && s.substring(j, i).equals(word)) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}