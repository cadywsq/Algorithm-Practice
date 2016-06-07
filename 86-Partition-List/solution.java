/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode dummyLeft = left;
        ListNode dummyRight = right;
        
        ListNode curr = head;
        while(curr != null) {
            if (curr.val < x) {
                left.next = new ListNode(curr.val);
                left = left.next;
            } else {
                right.next = new ListNode(curr.val);
                right = right.next;
            }
            curr = curr.next;
        }
        left.next = dummyRight.next;
        
        return dummyLeft.next;
    }
}