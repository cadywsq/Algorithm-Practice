public class Solution {
    /**
     * Since only one letter can be changed at a time, if we start from "hit", we can only change to those words which have only one different letter from it, like "hot". Putting in graph-theoretic terms, we can say that "hot" is a neighbor of "hit".

        The idea is simpy to begin from start, then visit its neighbors, then the non-visited neighbors of its neighbors... the typical BFS structure.

        To simplify the problem, we insert end into dict. Once we meet end during the BFS, we know we have found the answer. We maintain a variable distance for the current distance of the transformation and update it by distance++ after we finish a round of BFS search. 
        Also, to avoid visiting a word for more than once, we erase it from dict once it is visited.
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
                Queue<String> queue = new LinkedList<>();
        int distance = 1;
        queue.offer(beginWord);
        wordList.remove(beginWord);

        wordList.add(endWord);

        while (!queue.isEmpty()) {
            int wordCount = queue.size();

            for (int i = 0; i < wordCount; i++) {
                String curWord = queue.poll();
                char[] chars = curWord.toCharArray();
                for (int j = 0; j < curWord.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c) {
                            continue;
                        }
                        char temp = chars[j];
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (nextWord.equals(endWord)) {
                            return distance + 1;
                        }
                        if (wordList.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordList.remove(nextWord);
                        }
                        chars[j] = temp;
                    }
                }
            }
            distance++;
        }
        return 0;
    }
}