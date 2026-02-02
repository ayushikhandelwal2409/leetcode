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
    public ListNode doubleIt(ListNode head) {
        int carry=helper(head);
        if(carry!=0){
            ListNode nn=new ListNode(carry);
            nn.next=head;
            return nn;
        }
        return head;
    }
    public int helper(ListNode cur){
        if(cur==null){ 
            return 0;
        } 
        int carry= helper(cur.next);
        int k=cur.val*2+carry;
        cur.val=k%10;
        return k/10;
        
    }
}