public class Solution {
    private final int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (found(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean found(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (found(board, word, index+1, x, y, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
    
}