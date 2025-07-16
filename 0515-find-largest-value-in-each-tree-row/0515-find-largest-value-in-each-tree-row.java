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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if (root==null){
            return ans;
        }
        ans.add(root.val);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int rowsize=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<rowsize;i++){
                TreeNode currentNode = q.poll();
                if(currentNode.left!=null){
                    q.offer(currentNode.left);
                    max=Math.max(max,currentNode.left.val);
                }
                if(currentNode.right!=null){
                    q.offer(currentNode.right);
                    max=Math.max(max,currentNode.right.val);
                }  
            }
            ans.add(max);
        }
        ans.remove(ans.size()-1);
        return ans;
    }

}