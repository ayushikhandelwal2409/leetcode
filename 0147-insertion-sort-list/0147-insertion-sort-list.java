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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(0);
        ListNode cur=head;
        while(cur!=null){
            ListNode prev=dummy;
            ListNode next = cur.next;
            while(prev.next!=null && prev.next.val<cur.val){
              prev=prev.next;  
            }
            cur.next=prev.next;
            prev.next=cur;
            cur=next;
        }
        return dummy.next;
    }
}