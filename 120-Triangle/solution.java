public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minTotal = new int[row];

        for (int i = 0; i < row; i++) {
            List<Integer> curRow = triangle.get(i);
            // Attention: 
            // as the minTotal of position j of current row depends on value of position j-1 of last row, change for the current row should be from the end to the front.
            for (int j = i; j >= 0; j--) { 
                if (j == 0) {
                    minTotal[j] += curRow.get(j); // the first element of each row
                } else if (j == i) {
                    minTotal[j] = minTotal[j-1] + curRow.get(j); // the last element of each row.
                } else {
                    minTotal[j] = curRow.get(j) + Math.min(minTotal[j-1], minTotal[j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            min = Math.min(min, minTotal[i]);
        }
        return min;
    }
}