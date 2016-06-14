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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> nums = new ArrayList<>();
        getPaths(root, nums, "");
        
        int sum = 0;
        for (String num : nums) {
            sum += Integer.valueOf(num);
        }
        return sum;
    }
    
    private void getPaths(TreeNode root, List<String> nums, String s) {
        if (root == null) {
            return;
        }
        // if leaf is found.
        if (root.left == null && root.right == null) {
            nums.add(s + root.val);
            return;
        }
        getPaths(root.left, nums, s+root.val);
        getPaths(root.right, nums, s+root.val);
    }
}