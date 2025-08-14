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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        q.offer(new Pair<>(root,0));
        int max=0;
        while(!q.isEmpty()){
            int size=q.size();
            int levelstart=q.peek().getValue();
            int levelend=0;
            for(int i=0;i<size;i++){
                Pair<TreeNode, Integer> entry = q.poll();
                TreeNode node=entry.getKey();
                int pos=entry.getValue();
                levelend=pos;
                if(node.left!=null){
                    q.offer(new Pair<>(node.left,2*pos));
                }
                if(node.right!=null){
                    q.offer(new Pair<>(node.right,2*pos+1));
                }
            }
            max=Math.max(max,levelend-levelstart+1);
        }
        return max;
    }
}