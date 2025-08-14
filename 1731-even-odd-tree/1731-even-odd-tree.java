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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean evenlevel=true;
        while(!q.isEmpty()){
            int size=q.size();
            int prevval=evenlevel?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                 if (evenlevel) {
                    // Even level → values must be odd and strictly increasing
                    if (node.val % 2 == 0 || node.val <= prevval) return false;
                } else {
                    // Odd level → values must be even and strictly decreasing
                    if (node.val % 2 != 0 || node.val >= prevval) return false;
                }
                prevval=node.val;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            evenlevel=!evenlevel;
        }
        return true;
    }
}