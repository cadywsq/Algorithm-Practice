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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (!stack.isEmpty() || cur != null) {
            // when base case root==null not met, execute recursion preorder(root.left)
            if (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } 
            // when base case met, execute preorder(root.right)
            else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }
}