public class Solution {
    // As we are constructing BST, when root=k, the count equals 
    // (number of unique BSTs with k-1 nodes) * (number of unique BSTs with n-k nodes)
    // use bottom-up dp.
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        int[] numOfTrees = new int[n+1];
        numOfTrees[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                numOfTrees[i] += numOfTrees[k-1] * numOfTrees[i-k];
            }
        }
        return numOfTrees[n];
    }
}