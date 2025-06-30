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
    public ListNode partition(ListNode head, int x) {
ListNode smallerhead=new ListNode(0);
        ListNode biggerhead=new ListNode(0);
        ListNode small = smallerhead;
        ListNode big = biggerhead;
        while(head!=null){
            if(head.val<x){
                small.next=head;
                small=small.next;
            }
            else{
                big.next=head;
                big=big.next;
            }
            head=head.next;
        }
        small.next=biggerhead.next;
        big.next=null;
        return smallerhead.next;
    }
}