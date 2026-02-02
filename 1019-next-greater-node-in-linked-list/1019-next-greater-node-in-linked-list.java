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
    public int[] nextLargerNodes(ListNode head) {
       int[] ans=helper(head);
        return ans;
    }
    public int[] helper(ListNode cur){
        ArrayList<Integer> l=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        while(cur!=null){
            l.add(cur.val);
            cur=cur.next;
        }
        int[] ans=new int[l.size()];
        for(int i=l.size()-1;i>=0;i--){
            while(!st.isEmpty()  && l.get(st.peek())<=l.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=0;
            }
            else{
                ans[i]=l.get(st.peek());
            }
            st.push(i);
        }
        return ans;
    }
}