public class Solution {
    class TrieNode {
        private final TrieNode[] children;
        private String word;
        
        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = "";
        }
        
        public boolean contains(char c) {
            return children[c-'a'] != null;
        }
        
        public TrieNode get(char c) {
            if (contains(c)) {
                return children[c-'a'];
            }
            return null;
        }
        
        public void put(char c) {
            children[c-'a'] = new TrieNode();
        }
    }
    
    private final TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> founded = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;
        
        for (String word : words) {
            addWords(word);
        }
        TrieNode node = root;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, node, founded, visited);
            }
        }
        return founded;
    }
    
    private void dfs(char[][] board, int row, int col, TrieNode root, List<String> founded, boolean[][] visited) {
        if (row < 0 || col < 0 || row>=board.length || col>=board[0].length || visited[row][col]) {
            return;
        }
        
        root = root.get(board[row][col]);
        if (root == null) {
            return;
        }
        
        if (!root.word.equals("")) {
            founded.add(root.word);
            root.word = ""; // de-duplicate
        }
        
        visited[row][col] = true;
        dfs(board, row+1, col, root, founded, visited);
        dfs(board, row-1, col, root, founded, visited);
        dfs(board, row, col+1, root, founded, visited);
        dfs(board, row, col-1, root, founded, visited);
        visited[row][col] = false;
    }
    
    private void addWords(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.word = word;
    }
}