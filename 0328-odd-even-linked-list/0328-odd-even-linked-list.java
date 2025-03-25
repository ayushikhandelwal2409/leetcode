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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node
        }

        ListNode oddHead = new ListNode(0); // Dummy head for odd nodes
        ListNode evenHead = new ListNode(0); // Dummy head for even nodes
        ListNode odd = oddHead;
        ListNode even = evenHead;
        ListNode current = head;
        int index = 1; // Start with index 1 for the first node

        while (current != null) {
            if (index % 2 != 0) { // Odd index
                odd.next = current;
                odd = odd.next;
            } else { // Even index
                even.next = current;
                even = even.next;
            }
            current = current.next;
            index++;
        }

        // Connect the end of odd list to the head of even list
        odd.next = evenHead.next;
        even.next = null; // End the even list

        return oddHead.next; // Return the head of the rearranged list
    }
}