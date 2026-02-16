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
    int[] heights=new int[100001];
    //int query /index,ans
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n=queries.length;
        ht(root);
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        int k=0;
        for(int i:queries){
            map.computeIfAbsent(i, x -> new ArrayList<>()).add(k);
            k++;
        }
        Queue<TreeNode> q=new LinkedList<>();
        int[] ans=new int[n];
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            // ArrayList<TreeNode> ll=new ArrayList<>();
            int max=-1;
            int s_max=-1;
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(map.containsKey(node.val)){
                    l.add(node.val);
                }
                if(heights[node.val]>max){
                    s_max=max;
                    max=heights[node.val];
                }
                else if(heights[node.val]>s_max){
                    s_max=heights[node.val];
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            for(int j:l){
                for(int i:map.get(j)){
                    if(heights[j]==max){
                        ans[i]=s_max+level;
                    }
                    else{
                        ans[i]=max+level;
                    }
                }
            }
            level++;
        }
        return ans;
        
    }
    public int ht(TreeNode root){
        if(root==null){
            return -1;
        }
        heights[root.val]=1+ Math.max(ht(root.left),ht(root.right));
        return heights[root.val];
    }
}