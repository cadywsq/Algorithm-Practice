/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while (p1 != null && p2 != null) {
            int minVal = 0;
            if (p1.val <= p2.val) {
                minVal = p1.val;
                p1 = p1.next;
            }
            else if (p1.val > p2.val) {
                minVal = p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(minVal);
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return sentinel.next;
    }
}