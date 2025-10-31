/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> st=new Stack<>();
        Node curr=head;
        while(curr!=null){
            if(curr.child!=null){
                Node neighbour=curr.next;
                if(curr.next!=null) st.push(neighbour);
                curr.next=curr.child;
                curr.child.prev = curr;
                curr.child = null;
            } else if (curr.next == null && !st.isEmpty()) {
                Node nextNode = st.pop();
                curr.next = nextNode;
                nextNode.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}