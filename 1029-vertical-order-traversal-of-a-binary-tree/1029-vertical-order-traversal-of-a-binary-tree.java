/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair{
        TreeNode node;
        int row;
        int col;
        //constructor 
        public pair(TreeNode node,int row,int col){
            this.row=row;
            this.col=col;
            this.node=node;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Queue<pair> q=new LinkedList<>();
        TreeMap<Integer,List<pair>> map=new TreeMap<>();
        q.add(new pair(root,0,0));
        while(!q.isEmpty()){
            pair p=q.poll();
            if(!map.containsKey(p.col)){
                map.put(p.col,new ArrayList<>());
            }
            map.get(p.col).add(p);
            if(p.node.left!=null){
                q.add(new pair(p.node.left,p.row+1,p.col-1));
            }
            if(p.node.right!=null){
                q.add(new pair(p.node.right,p.row+1,p.col+1));
            }
            
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int key:map.keySet()){
            List<pair> ll=map.get(key);
            Collections.sort(ll,new Comparator<pair>(){
                @Override
                public int compare(pair o1,pair o2){
                    if(o1.row==o2.row){
                        return o1.node.val-o2.node.val;
                    }
                    return 0;
                }
            });
            List<Integer> list=new ArrayList<>();
            for(pair v:ll){
                list.add(v.node.val);
            }
            ans.add(list);
        }
        return ans;
    }
}