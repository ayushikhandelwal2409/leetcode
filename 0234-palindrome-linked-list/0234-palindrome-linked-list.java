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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;                     
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }  
        ListNode second_half=reverse(slow);
        ListNode curr=head;
        while(second_half!=null){
            if(second_half.val!=curr.val) return false;
            curr=curr.next;
            second_half=second_half.next;
        } 
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextemp;
        }
        return prev;
    }
}