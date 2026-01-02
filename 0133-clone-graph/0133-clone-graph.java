/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        Node nn= new Node(node.val);
        // ArrayList<Node> k=new ArrayList<>(node.neighbors);
        // nn.val=node.val;
        // nn.neighbors=k;
        Node[] vis=new Node[101];
        Arrays.fill(vis,null);
        dfs(node,nn,vis);
        return nn;
    }
    public static void dfs(Node node,Node nn,Node[] vis){
        vis[nn.val]=nn;
        for(Node neighbour:node.neighbors){
            if(vis[neighbour.val]==null){
                Node newnode=new Node(neighbour.val);
                nn.neighbors.add(newnode);
                dfs(neighbour,newnode,vis);
            }
            else{
                nn.neighbors.add(vis[neighbour.val]);
            }
        }

    }
}