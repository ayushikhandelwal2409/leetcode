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
        ListNode dummy=new  ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        int c=0;
        while(cur.next!=null){
            cur=cur.next;
            c++;
        }
            
        int k=c-n;
        cur=dummy;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}