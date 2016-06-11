/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // no need to do null-check for l1, l2.
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        // create extra pointer to avoid p1, p2 referencing object being changed.
        ListNode p1 = l1;
        ListNode p2 = l2;
        int sum = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum = sum / 10;
        }
        // check whether there is carry left after complete traversal.
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return sentinel.next;
    }
}