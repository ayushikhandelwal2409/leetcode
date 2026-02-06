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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prevGrpEnd=dummy;
        while(true){
            ListNode kthNode=prevGrpEnd;
            for(int i=0;i<k;i++){
                kthNode=kthNode.next;
                if(kthNode==null){
                    return dummy.next;
                }
            }
            ListNode nextGrpStart=kthNode.next;
            ListNode prev=nextGrpStart;
            ListNode  cur=prevGrpEnd.next;
            while(cur!=nextGrpStart){
                ListNode temp=cur.next;
                cur.next=prev;
                prev=cur;
                cur=temp;
            }
            ListNode temp=prevGrpEnd.next;
            prevGrpEnd.next=kthNode;
            prevGrpEnd=temp;
        }
       // return head;
    }
}