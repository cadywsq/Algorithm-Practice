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
        pathSum(root, sum, result, new ArrayList<>());
        return result;
    }
    
    private void pathSum(TreeNode root, int target, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        // check whether reached leaf
        if (root.left == null && root.right == null && root.val == target) {
            result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        
        pathSum(root.left, target-root.val, result, path);
        pathSum(root.right, target-root.val, result, path);
        
        path.remove(path.size()-1);
    }
}