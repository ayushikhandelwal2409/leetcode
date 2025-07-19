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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelsize=q.size();
            double sum=0;
            for(int i=0;i<levelsize;i++){
                TreeNode k=q.poll();
                sum+=k.val;
                if(k.left!=null){
                    q.add(k.left);
                }
                if(k.right!=null){
                    q.add(k.right);
                }
            }
            ans.add(sum/levelsize);
        }
        return ans;
    }
}