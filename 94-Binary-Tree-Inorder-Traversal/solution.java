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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            // inorder(root.left)
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // add root to list
            cur = stack.pop();
            result.add(cur.val);
            // inorder(root.right)
            cur = cur.right;
        } 
        return result;
    }
}