/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        solution2(root);
    }
    
    /**Solution1: BFS
     */
     private void solution1(TreeLinkNode root) {
         Queue<TreeLinkNode> queue = new LinkedList<>();
         queue.offer(root);
         int curLevelSize = 1;
         int nextLevelSize = 0;
         
         while (!queue.isEmpty()) {
             TreeLinkNode cur = queue.poll();
             curLevelSize--;
             if (cur.left != null) {
                 queue.offer(cur.left);
                 nextLevelSize++;
             }
             if (cur.right != null) {
                 queue.offer(cur.right);
                 nextLevelSize++;
             }
             
             if (curLevelSize == 0) {
                 curLevelSize = nextLevelSize;
                 nextLevelSize = 0;
             } else {
                 cur.next = queue.peek();
             }
         }
         
     }
     
    /**Solution2: Very smart BFS solution, constant space
     * Process the nodes level by level.
     * Keep two pointers, pre pioints to leftmost node of a level, cur travels to each node at same level with pre.
     */
    private void solution2(TreeLinkNode root) {
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}