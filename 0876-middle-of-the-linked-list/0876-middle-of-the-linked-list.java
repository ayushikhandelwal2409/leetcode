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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        int c=0;
        while (fast != null ) {
            c+=1;
            fast = fast.next;
        }
        int f=0;
        fast = head;
        while(fast != null){
            f+=1;
            if(f==(c/2)+1)
            {
                break;
            }
            fast=fast.next;
            
        }
        return fast;
    }
}