/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode fast = sentinel;
        ListNode slow = sentinel;
        
        int length = 0;
        // move the fast pointer to the end of the list.
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }
        // move the slow pointer to end node of new list.
        // rotate k position equals the kth node from end of list is the end node of the new list.
        for (int i = 0; i < length-k%length; i++) {
            slow = slow.next;
        }
        fast.next = head;
        sentinel.next = slow.next;
        slow.next = null;
        
        return sentinel.next;
    }
}