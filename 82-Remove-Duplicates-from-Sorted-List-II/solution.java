/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        
        ListNode prev = sentinel;
        ListNode cur = prev.next;
        
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // if there is duplicated values between prev and cur, prev pointer stays.
            if (prev.next != cur) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }
}