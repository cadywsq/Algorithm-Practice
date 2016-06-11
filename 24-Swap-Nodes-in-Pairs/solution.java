/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pre = sentinel;
        ListNode cur = pre.next;
        ListNode next = cur.next;
        
        while (cur != null && next != null) {
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;
            if (cur != null) {
                next = cur.next;
            }
        }
        return sentinel.next;
    }
}