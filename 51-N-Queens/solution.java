public class Solution {
        public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        for (int i = 0; i < n; i++) {
            char[][] board = formNewBoard(n, i);
            solveHelper(board, 1, results);
        }
        return results;
    }

    private void solveHelper(char[][] board, int row, List<List<String>> results) {
        if (row == board.length) {
            addValidResult(board, results);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isLegal(board, row, i)) {
                board[row][i] = 'Q';
                solveHelper(board, row + 1, results);
                board[row][i] = '.';
            }
        }
    }

    private boolean isLegal(char[][] board, int row, int col) {
        // check row and col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q' || board[row][i] == 'Q') {
                return false;
            }
        }
        // check diagonal line
        int diff = row - col;
        int sum = row + col;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!(i == row && j == col) && (i - j == diff || i + j == sum)) {
                    if (board[i][j] == 'Q') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void addValidResult(char[][] board, List<List<String>> results) {
        List<String> oneResult = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            oneResult.add(sb.toString());
        }
        results.add(oneResult);
    }

    private char[][] formNewBoard(int n, int col) { //col is for position of first Q.
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == col) {
                    board[i][j] = 'Q';
                } else {
                    board[i][j] = '.';
                }
            }
        }
        return board;
    }
}