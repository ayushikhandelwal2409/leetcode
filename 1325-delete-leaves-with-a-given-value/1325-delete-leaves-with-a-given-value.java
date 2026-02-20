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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return helper(root,target);
    }
    public TreeNode helper(TreeNode root ,int t){
        if(root==null){
            return null;
        }
        root.left=helper(root.left,t);
        // if(root.left==null && root.right==null && root.val==t){
        //     root.left=null;
        // }
        root.right=helper(root.right,t);
        if(root.left==null && root.right==null && root.val==t){
            return null;
        }
        return root;
    }
}