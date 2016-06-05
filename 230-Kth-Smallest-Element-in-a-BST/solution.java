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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        if (root.left != null) {
            count = countNodes(root.left);
        }
        
        // index for root is count+1 in this case.
        if (k > count+1) {
            // if k is greater than index of root, go to right sub-tree 
            // to find the one with index k-count-1.
            return kthSmallest(root.right, k-count-1);
        } else if (k <= count) {
            // if k is lesser than index of root, go to left sub-tree.
            return kthSmallest(root.left, k);
        }
        return root.val;
        
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}