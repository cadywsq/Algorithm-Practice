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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder2(root);
    }
    
    /**Solution1: Preorder traversal to build tree
     * root--left--right order to traverse the tree to the end, bottom-up recursively to reconstruct the tree.
     */
     private void preorder(TreeNode root) {
         if (root == null) {
             return;
         }
         preorder(root.left);
         preorder(root.right);
         
         //Record right subtree, change left subtree as right subtree, and set left subtree as null.
         TreeNode temp = root.right;
         root.right = root.left;
         root.left = null;
        
        //Find right-most node of current tree, and link previous flattened right subtree.
        TreeNode cur = root;
         while (cur.right != null) {
             cur = cur.right;
         }
         cur.right = temp;
     }
     
    
    /**Solution2: Preorder traversal to build tree (solution1 optimized)
     */
    private TreeNode preorder2(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        
        if (root.left != null) {
            left = preorder2(root.left);
        }
        if (root.right != null) {
            right = preorder2(root.right);
        }
        
        if (left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            left.right = temp;
        } 
        
        if (right != null) {
            return right;
        } 
        return left;
    }
    
    /**Solution2: Go down through the left, when right is not null, push right to stack.
     */
     private void stackSolution(TreeNode root) {
         Stack<TreeNode> stack = new Stack<>();

         while (!stack.isEmpty() && root != null) {
             if (root.right != null) {
                 stack.push(root.right);
             }
             
             if (root.left != null) {
                 root.right = root.left;
                 root.left = null;
             } else {
                 TreeNode temp = stack.pop();
                 root.right = temp;
             }
             root = root.right;
         }
     }
}