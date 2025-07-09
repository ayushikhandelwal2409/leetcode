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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans =new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int k=0;
        while(!q.isEmpty()){
            int height=q.size();
            ArrayList<Integer> current = new ArrayList<>();
            for(int i=0;i<height;i++){
                TreeNode node=q.poll();
                if(k%2==0){
                    current.add(node.val);
                }
                else {
                    current.add(0, node.val); 
                }
                if (node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            k++;
            ans.add(current);
        }
        return ans;
    }
}