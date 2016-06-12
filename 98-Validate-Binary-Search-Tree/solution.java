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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long leftMax, long rightMin) {
        if (root == null) {
            return true;
        }
        if (root.val >= leftMax || root.val <= rightMin) {
            return false;
        }
        return isValidBST(root.left, root.val, rightMin) && isValidBST(root.right, leftMax, root.val);
    }
}