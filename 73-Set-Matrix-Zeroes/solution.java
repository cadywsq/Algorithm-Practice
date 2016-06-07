public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        int rowFlag = 1;
        int colFlag = 1;
        // traverse first row and col, mark them with flag whether to set all zero.
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                colFlag = 0;
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = 0;
                break;
            }
        }
        
        // traverse whole matrix, use first row, first col value as flags to mark whether to set entire row or col as zeroes.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // traverse whole matrix, if corresponding element in first row or col is zero, set the current value to zero.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // check rowFlag and colFlag to reset first row and first col
        if (rowFlag == 0) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag == 0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}