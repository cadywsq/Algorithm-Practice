/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // return reverseKGroup1(head, k);
        return reverseKGroup2(head, k);
    }
    
    /**Recursive*/
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        // find the (k+1)th node
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            // reverse k nodes and set (k+1)th node as head
            cur = reverseKGroup1(cur, k);
            while (count-- > 0) {
                // head : head-pointer to direct part, 
                // curr : head-pointer to reversed part;
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
    
    /**Iterative*/
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        // get the length of list
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        
        // create a dummy node and a pre pointer
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // reverse in k groups
        cur = pre.next;
        ListNode reHead = null;
        for (int i = 1; i*k <= len; i++) {
            //Reverse pre->n1->n2->...->nk-> to pre->nk->...->n2->n1->
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                cur.next = reHead;
                reHead = cur;
                cur = next;
            }
            // pre points to n1, pre.next points to nk+1, then continue the loop
            pre.next.next = cur;
            ListNode temp = pre.next;
            pre.next = reHead;
            pre = temp;
        }
        return dummy.next;
    }   
}