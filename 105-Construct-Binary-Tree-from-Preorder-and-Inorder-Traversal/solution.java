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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        //Value of root of current tree.
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        //Position of root value in inorder.
        int pos = findPos(inorder, inStart, inEnd, rootVal);
        //Size of left subtree.
        int leftSize = pos - inStart;
        
        //Construct left subtree.
        root.left = buildTree(preorder, inorder, preStart+1, preStart+leftSize, inStart, pos-1);
        //Construct right subtree
        root.right = buildTree(preorder, inorder, preStart+leftSize+1, preEnd, pos+1, inEnd);
        
        return root;
    }
    
    private int findPos(int[] inorder, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}