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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to the node just before the `left` position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Step 2: Push nodes from `left` to `right` onto the stack
        ListNode current = prev.next;
        for (int i = 0; i <= right - left; i++) {
            stack.push(current);
            current = current.next;
        }

        // Step 3: Pop from the stack to reverse the nodes
        //ListNode tail = prev.next; // This will be the tail after reversal
        while (!stack.isEmpty()) {
            prev.next = stack.pop();
            prev = prev.next;
        }

        // Step 4: Connect the tail to the next node after `right`
        prev.next = current;

        return dummy.next; // Return the new head of the list
    }
}