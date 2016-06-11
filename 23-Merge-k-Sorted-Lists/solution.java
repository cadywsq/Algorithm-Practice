/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        while (!queue.isEmpty()) {
            // get the node with smallest value from queue, offer node.next to the queue afterwards.
            ListNode smallest = queue.poll();
            cur.next = new ListNode(smallest.val);
            cur = cur.next;
            if (smallest.next != null) {
                queue.offer(smallest.next);
            }
        }
        return sentinel.next;
    }
}