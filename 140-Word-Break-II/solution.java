public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        boolean[] canBreak = canBreak(s, wordDict);
        List<String> result = wordBreak(s, wordDict, s.length(), canBreak);
        return result;
    }
    
    private List<String> wordBreak(String s, Set<String> wordDict, int index, boolean[] canBreak) {
        List<String> list = new ArrayList<>();
        
        //Return an empty list if cannot break
        if (!canBreak[index]) {
            return list;
        }
        //Return a list containing an empty string if reach end
        if (index == 0) {
            list.add("");
            return list;
        }
        for (int i = index-1; i >= 0; i--) {
            String suffix = s.substring(i, index);
            if (wordDict.contains(suffix)) {
                for (String prefix : wordBreak(s, wordDict, i, canBreak)) {
                    String space = null;
                    if (prefix.length() == 0) {
                        space = "";
                    } else {
                        space = " ";
                    }
                    list.add(prefix + space + suffix);
                }
            }
        }
        return list;
    }
    
    private boolean[] canBreak(String s, Set<String> wordDict) {
        int len = s.length();
        // canBreak[i] represents that s.substring(0,i) is breakable, i excluded.
        boolean[] canBreak = new boolean[len+1];
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
        return canBreak;
    }
}