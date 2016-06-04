public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        
        // check whether the string can be segmented using words in dict
        int len = s.length();
        boolean[] canBeSegmented = new boolean[len+1];
        canBeSegmented[0] = true;
        
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (canBeSegmented[j] && wordDict.contains(s.substring(j,i))) {
                    canBeSegmented[i] = true;
                    break;
                }
            }
        }
        if (!canBeSegmented[len]) {
            return result;
        }
        
        // if string can be segmented, process to add possible results to final list.
        wordBreakHelper(s, wordDict, "", 0, result);
        return result;
    }
    
    private void wordBreakHelper(String s, Set<String> wordDict, String res, int start, List<String> result) {
        if (start == s.length()) {
            result.add(res);
            return;
        }
        
        // append a whitespace after last word appended.
        if (res.length() != 0) {
            res += " ";
        }
        
        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i+1);
            if (wordDict.contains(word)) {
                // indicate that s[start,i) is a word exists in dict, continue to check s[i+1,len)
                wordBreakHelper(s, wordDict, res+word, i+1, result);
            }
        }
    }
}