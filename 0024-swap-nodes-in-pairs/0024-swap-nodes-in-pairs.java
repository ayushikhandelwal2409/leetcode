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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Pointer to keep track of the current node
        ListNode current = dummy;

        // Iterate through the list in pairs
        while (current.next != null && current.next.next != null) {
            // Identify the two nodes to swap
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Perform the swap
            first.next = second.next; // Link first node to the node after second
            current.next = second; // Link current node to the second node
            second.next = first; // Link second node to the first node

            current = first;
        }
        return dummy.next;
    }
}