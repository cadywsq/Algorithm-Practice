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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLeftHeight(root.left);
        int right = getRightHeight(root.right);
        
        // if left height equals right height, it's a full tree. node size is 2^h-1.
        if (left == right) {
            return (2 << left) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int getLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getLeftHeight(root.left) + 1;
    }
    
    private int getRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getRightHeight(root.right)+1;
    }
}