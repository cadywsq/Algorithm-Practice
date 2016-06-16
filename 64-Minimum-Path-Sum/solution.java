public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] minSum = new int[row][col];
        minSum[0][0] = grid[0][0];
        
        for (int i = 1; i < row; i++) {
            minSum[i][0] = minSum[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            minSum[0][i] = minSum[0][i-1] + grid[0][i];
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                minSum[i][j] = Math.min(minSum[i-1][j], minSum[i][j-1]) + grid[i][j];
            }
        }
        return minSum[row-1][col-1];
    }
}