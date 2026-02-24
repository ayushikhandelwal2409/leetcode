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
    int ans=0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root,root.val);
        return ans;
    }
    public void helper(TreeNode root,int val){
        if(root.left==null && root.right==null){
            ans+=val;
            return;
        }
        if(root.left!=null){
            helper(root.left,val*2+root.left.val);
        }
        if(root.right!=null){
            helper(root.right,val*2+root.right.val);
        }
    }
}