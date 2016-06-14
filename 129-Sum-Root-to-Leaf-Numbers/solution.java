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
        return solution2(root);
    }
    
    /**Solution1: append each path into a list of string, convert to numbers and sum up.
     */
    private int solution1(TreeNode root) {
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
    
    /**Solution2: sum up while reaching each node and multiply previous sum by 10 and add current node value.
     */
     private int solution2(TreeNode root) {
         return getSum(root, 0);
     }
     
     private int getSum(TreeNode root, int sum) {
         if (root == null) {
             return 0;
         }
         sum = sum * 10 + root.val;
         // when reaching a leaf
         if (root.left == null && root.right == null) {
             return sum;
         }
         return getSum(root.left, sum) + getSum(root.right, sum);
     }
}