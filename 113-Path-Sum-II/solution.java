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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSum(root, sum, result, new ArrayList<>());
        return result;
    }
    
    private void pathSum(TreeNode root, int target, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        
        path.add(root.val);
        // check whether reached leaf
        if ((root.left == null && root.right == null) || root.left!=null){
            pathSum(root.left, target-root.val, result, path);
        }
        if (root.right != null) {
            pathSum(root.right, target-root.val, result, path);
        }
        
        path.remove(path.size()-1);
    }
}