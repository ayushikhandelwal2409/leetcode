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
    int mod=1_000_000_007;
    long max=0;
    long sum=0;
    public int maxProduct(TreeNode root) {
        sum=change(root);
        helper(root);
        return (int)(max%mod);
    }
    public long change(TreeNode root){
        if(root==null){
            return 0;
        }
        long leftsum=change(root.right);
        long rightsum=change(root.left);
        root.val+=leftsum+rightsum;
        return root.val;
    }
    public  void helper(TreeNode root){
        if(root==null){
            return ;
        }
        long ans=(sum-root.val)*root.val;
        max=Math.max(ans,max);
        helper(root.left);
        helper(root.right);
    }
}