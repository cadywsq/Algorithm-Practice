public class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        // for each word, mark each character in corresponding position, 0 as not exist, 1 as exist.
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                mask[i] |= (1<<(c-'a'));
            }
        }
        // check whether there are duplicated characters for each two words, and update max product accordingly.
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                // be careful that all bit manipulation related expression need to be parenthesised.
                if ((mask[i] & mask[j]) == 0 && words[i].length() * words[j].length() > max) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}