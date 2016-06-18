/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] max = robHelper(root);
        return Math.max(max[0],max[1]);
    }
    
    private int[] robHelper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        
        int[] result = new int[2];
        // result[0] represents the max not robbing current root
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        // result[1] represents max got by robbing current root.
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}