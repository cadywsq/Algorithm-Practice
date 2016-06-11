/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode cur = head;
        while (cur != null) {
            while (cur != null && cur.val == val) {
                cur = cur.next;
            }
            prev.next = cur;
            prev = cur;
            if (cur != null) {
                cur = cur.next;
            }
        }
        return sentinel.next;
    }
}