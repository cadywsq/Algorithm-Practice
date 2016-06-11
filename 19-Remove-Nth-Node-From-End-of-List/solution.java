/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int len = getLength(head);
        if (n > len) {
            throw new AssertionError();
        }
        
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode cur = head;
        for (int i = 0; i < len-n; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return sentinel.next;
    }
    
    private int getLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            len += 2;
        }
        return fast==null ? len : len+1;
    }
}