/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        pre(ans,root);
        return ans;
    }
    public void pre(ArrayList<Integer> l,Node root){
        l.add(root.val);
        for(Node child:root.children){
            pre(l,child);
        }
    }
}