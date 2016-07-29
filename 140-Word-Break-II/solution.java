public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        boolean[] canBreak = canBreak(s, wordDict);
        List<String> result = wordBreakHelper(s, wordDict, canBreak, s.length());
        return result;
    }
    
    private List<String> wordBreakHelper(String s, Set<String> wordDict, boolean[] canBreak, int index) {
        List<String> result = new ArrayList<>();
        if (!canBreak[index]) {
            return result;
        }
        if (index == 0) {
            result.add("");
            return result;
        }
        for (int i = index-1; i >= 0; i--) {
            String suffix = s.substring(i, index);
            if (wordDict.contains(suffix)) {
                for (String prefix : wordBreakHelper(s, wordDict, canBreak, i)) {
                    String space;
                    if (prefix.equals("")) {
                        space = "";
                    } else {
                        space = " ";
                    }
                    result.add(prefix + space + suffix);
                }
            }
        }
        return result;
    }
    
    private boolean[] canBreak(String s, Set<String> wordDict) {
        // canBreak[i] represents that s.substring(0,i) is breakable, i excluded.
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int j = i - word.length();
                if (j >= 0 && canBreak[j] && s.substring(j, i).equals(word)) {
                    canBreak[i] = true;
                }
            }
        }
        return canBreak;
    }
}