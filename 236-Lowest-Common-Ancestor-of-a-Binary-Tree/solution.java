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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if the node is found, LCA is itself
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        // if p,q on both side of tree, LCA is the root.
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        // if both nodes are in one subtree, LCA is the LCA of the subtree
        if (leftLCA == null) {
            return rightLCA;
        }
        if (rightLCA == null) {
            return leftLCA;
        }
        // if p, q not found, LCA is null
        return null;
    }
}