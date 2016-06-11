/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode p1 = head;
        RandomListNode p2 = newHead;
        Map<RandomListNode, RandomListNode> oldToNew = new HashMap<>();
        oldToNew.put(p1,p2);
        
        // deep copy all nodes with their next pointers updated.
        while (p1.next != null) {
            p2.next = new RandomListNode(p1.next.label);
            p1 = p1.next;
            p2 = p2.next;
            oldToNew.put(p1, p2);
        }

        // update random pointers of each node in new list.
        p1 = head;
        p2 = newHead;
        while (p1 != null) {
            if (p1.random != null) {
                p2.random = oldToNew.get(p1.random);
            } 
            p1 = p1.next;
            p2 = p2.next;
        }
        return newHead;
    }
}