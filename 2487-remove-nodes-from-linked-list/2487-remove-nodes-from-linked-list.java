/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;

        ListNode newHead = removeNodes(head.next);
        if (newHead != null && head.val < newHead.val) {
            return newHead;
        } else {
            head.next = newHead;
            return head;
        }
    }
}