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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        buildPaths(root, "", result);
        return result;
    }
    
    private void buildPaths(TreeNode root, String s, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(s + root.val);
            return;
        }
        s += root.val + "->";
        buildPaths(root.left, s, result);
        buildPaths(root.right, s, result);
    }
}