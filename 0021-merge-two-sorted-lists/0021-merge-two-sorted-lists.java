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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode a=list1;
        ListNode b=list2;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(a!=null && b!=null){
            if(a.val<b.val){
                curr.next=a;
                a=a.next;
            }
            else{
                curr.next=b;
                b=b.next;
            }
            curr=curr.next;
        }
        while(a!=null){
            curr.next=a;
            a=a.next;
            curr=curr.next;
        }
        while(b!=null){
            curr.next=b;
            b=b.next;
            curr=curr.next;
        }
        curr.next=null;
        return dummy.next;
    }
}