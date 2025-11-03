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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            l++;
        }
        int k=l-n+1;
        if (k == 1) {
            return head.next;
        }
        curr=head;
        ListNode prev=null;
        while(curr!=null){
            k--;
            if(k==0){
                prev.next=curr.next;
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        return head;
    }
}