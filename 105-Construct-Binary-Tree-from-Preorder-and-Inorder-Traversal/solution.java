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
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        // find inorder index for the root
        int pos = findPos(inorder, inStart, inEnd, rootVal);
        int leftSize = pos - inStart;
        
        TreeNode left = buildTree(preorder, inorder, preStart+1, preStart+leftSize, inStart, pos-1);
        TreeNode right = buildTree(preorder, inorder, preStart+leftSize+1, preEnd, pos+1, inEnd);
        
        root.left = left;
        root.right = right;
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