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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currentnode=dummy;
        while(currentnode.next != null){
            if (currentnode.next.val == val) {
                currentnode.next = currentnode.next.next;
            } else {
                currentnode = currentnode.next;
            }
        }
        return dummy.next;
        
    }
}