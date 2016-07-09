public class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> letterMap = new HashMap<>();
        char[] chars = s.toCharArray();
        // step1: find the last index for each char.
        for (int i = 0; i < s.length(); i++) {
            letterMap.put(chars[i], i);
        }
        // step2: for each character, find the smallest index in the map, then find the smallest letter before the index
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = findSmallestIndex(letterMap);
        
        while (!letterMap.isEmpty()) {
            char cur = 'z'+1;
            int index = 0;
            for (int i = start; i <= end; i++) {
                if (chars[i] < cur && letterMap.containsKey(chars[i])) {
                    cur = chars[i];
                    index = i;
                }
            }
            // append result
            sb.append(cur);
            letterMap.remove(cur);
            // update the start and end indices
            start = index + 1;
            end = findSmallestIndex(letterMap);
        }
        return sb.toString();
    }
    
    private int findSmallestIndex(Map<Character, Integer> letterMap) {
        int result = Integer.MAX_VALUE;
        for (int index : letterMap.values()) {
            result = Math.min(result, index);
        }
        return result;
    }
}

/**
 * The basic idea is to find out the smallest result letter by letter (one letter at a time). Here is the thinking process for input "cbacdcbc":
find out the last appeared position for each letter; c - 7 b - 6 a - 2 d - 4
find out the smallest index from the map in step 1 (a - 2);
the first letter in the final result must be the smallest letter from index 0 to index 2;
repeat step 2 to 3 to find out remaining letters.
the smallest letter from index 0 to index 2: a
the smallest letter from index 3 to index 4: c
the smallest letter from index 4 to index 4: d
the smallest letter from index 5 to index 6: b
so the result is "acdb"
Notes:
after one letter is determined in step 3, it need to be removed from the "last appeared position map", and the same letter should be ignored in the following steps
in step 3, the beginning index of the search range should be the index of previous determined letter plus one
*/