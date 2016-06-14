public class Solution {
    public void solveSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return;
        }
        solveHelper(board, 0);
    }
    
    // traverse through every cell row by row.
    private boolean solveHelper(char[][] board, int index) {
        if (index == 81) {
            return true;
        }
        int row = index / 9; 
        int col = index % 9;
        
        if (board[row][col] != '.') {
            return solveHelper(board, index+1);
        }
        
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (solveHelper(board, index+1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
        
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        // check the row validness
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        // check the col validness
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }
        // check the block validness
        for (int i = row/3*3; i < row/3*3+3; i++) {
            for (int j = col/3*3; j < col/3*3+3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}