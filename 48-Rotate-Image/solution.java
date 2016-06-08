public class Solution {
    /** Rotate layer by layer.
     *      [old]     [new]
     *      left  --> up
     *      down  --> left
     *      right --> down
     *      up    --> right
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer <= n/2; layer++) {
            for (int i = 0; i < n-1-layer*2; i++) {
                // save the up as temp
                int temp = matrix[layer][layer+i];
                //left  --> up
                matrix[layer][layer+i] = matrix[n-1-layer-i][layer];
                //down  --> left
                matrix[n-1-layer-i][layer] = matrix[n-1-layer][n-1-layer-i];
                //right --> down
                matrix[n-1-layer][n-1-layer-i] = matrix[layer+i][n-1-layer];
                //up    --> right
                matrix[layer+i][n-1-layer] = temp;
            }
        }
    }
}