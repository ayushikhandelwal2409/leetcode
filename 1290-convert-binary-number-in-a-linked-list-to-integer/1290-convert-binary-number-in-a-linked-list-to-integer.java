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
    public int getDecimalValue(ListNode head) {
        StringBuilder sb=new StringBuilder();
        int c=0;
        while(head!=null){
            sb.append(head.val);
            head=head.next;
            c++;
        }
        int ans=0;
        int i=0;
        c--;
        System.out.println(c);
        while(c>=0){
            ans+=((int)(sb.charAt(i)-'0')*Math.pow(2,c));
            i++;
            c--;
        }
        return ans;
    }
}