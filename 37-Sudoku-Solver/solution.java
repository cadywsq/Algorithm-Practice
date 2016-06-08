public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }
    
//  Find row, col of an unassigned cell
    //   If there is none, return true
    //   For digits from 1 to 9
        //     a) If there is no conflict for digit at row,col
        //         assign digit to row,col and recursively try fill in rest of grid
        //     b) If recursion successful, return true
        //     c) Else, remove digit and try another
    //   If all digits have been tried and nothing worked, return false
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        // if all cells are assigned
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char c) {
        // check the ith row
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        // check the ith col
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        // check the block
        for (int row = i/3*3; row < i/3*3+3; row++) {
            for (int col = j/3*3; col < j/3*3+3; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}