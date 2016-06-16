public class WordDictionary {
    class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public boolean contains(char c) {
            return children[c - 'a'] != null;
        }

        public void put(char c) {
            children[c - 'a'] = new TrieNode();
        }

        public TrieNode get(char c) {
            if (contains(c)) {
                return children[c - 'a'];
            }
            return null;
        }
    }

    private final TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode node = root;
        return searchHelper(word, node, 0);
    }

    private boolean searchHelper(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            // dfs to traverse each child until the leaf node
            for (int i = 0; i < 26; i++) {
                TrieNode child = node.children[i];
                if (child != null && searchHelper(word, child, index+1)) {
                    return true;
                }
            }
            return false;
        } 
        // if the current character is not '.'
        // don't forget the null check!!!
        return node.get(c) != null && searchHelper(word, node.get(c), index+1);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");